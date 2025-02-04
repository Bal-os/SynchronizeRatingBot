package balashov.os.synchronizeratingbot.infrastructure.jpa.common.adapters;

import balashov.os.synchronizeratingbot.core.common.member.ports.GetMember;
import balashov.os.synchronizeratingbot.core.common.member.ports.SaveMemberRepository;
import balashov.os.synchronizeratingbot.core.common.memberstatus.ports.entities.MemberStatuses;
import balashov.os.synchronizeratingbot.core.common.memberstatus.ports.repossitories.SaveUserStatusRepository;
import balashov.os.synchronizeratingbot.core.common.memberstatus.ports.repossitories.UpdateUserStatusRepository;
import balashov.os.synchronizeratingbot.core.common.memberstatus.ports.usecases.CheckChatMembership;
import balashov.os.synchronizeratingbot.core.common.memberstatus.ports.usecases.GetUserStatus;
import balashov.os.synchronizeratingbot.infrastructure.jpa.common.entities.MemberEntity;
import balashov.os.synchronizeratingbot.infrastructure.jpa.common.mappers.ChatMapper;
import balashov.os.synchronizeratingbot.infrastructure.jpa.common.mappers.MemberMapper;
import balashov.os.synchronizeratingbot.infrastructure.jpa.common.mappers.UserMapper;
import balashov.os.synchronizeratingbot.infrastructure.jpa.common.repositories.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MemberAdaptersFactory {
    private final MemberRepository repository;
    private final MemberMapper mapper;
    private final UserMapper userMapper;
    private final ChatMapper chatMapper;

    @Bean
    public SaveMemberRepository saveChatMemberRepository() {
        return chatMember -> repository.save(mapper.mapToEntity(chatMember));
    }

    @Bean
    public CheckChatMembership checkSavedChatMembership() {
        return (chat, user) -> repository.findByChatAndUserAndStatusIn(chatMapper.mapToEntity(chat),
                userMapper.mapToEntity(user), MemberStatuses.members()).isEmpty();
    }

    @Bean
    public GetMember getSavedChatMember(MemberRepository memberRepository) {
        return (chat, user) -> memberRepository.findByChatAndUser(chatMapper.mapToEntity(chat),
                        userMapper.mapToEntity(user))
                .map(mapper::mapToDto);
    }

    @Bean
    public GetUserStatus getSavedUserStatus(MemberRepository memberRepository) {
        return (chat, user) -> memberRepository.findByChatAndUser(chatMapper.mapToEntity(chat),
                        userMapper.mapToEntity(user))
                .map(MemberEntity::getStatus);
    }

    @Bean
    public UpdateUserStatusRepository updateSavedUserStatus() {
        return (chat, user, status) -> repository.updateStatusByChatAndUser(chatMapper.mapToEntity(chat),
                userMapper.mapToEntity(user), status);
    }

    @Bean
    public SaveUserStatusRepository saveUserStatusRepository() {
        return (chat, user, status) -> repository.save(MemberEntity.builder()
                .chat(chatMapper.mapToEntity(chat))
                .user(userMapper.mapToEntity(user))
                .status(status)
                .build());
    }
}

package balashov.os.synchronizeratingbot.infrastructure.jpa.common.adapters;

import balashov.os.synchronizeratingbot.core.common.memberstatus.ports.entities.MemberStatuses;
import balashov.os.synchronizeratingbot.core.common.memberstatus.ports.usecases.CheckAdminRole;
import balashov.os.synchronizeratingbot.core.common.memberstatus.ports.usecases.GetAdministeredChats;
import balashov.os.synchronizeratingbot.core.common.memberstatus.ports.usecases.GetChatAdmins;
import balashov.os.synchronizeratingbot.infrastructure.jpa.common.entities.MemberEntity;
import balashov.os.synchronizeratingbot.infrastructure.jpa.common.mappers.ChatMapper;
import balashov.os.synchronizeratingbot.infrastructure.jpa.common.mappers.MemberMapper;
import balashov.os.synchronizeratingbot.infrastructure.jpa.common.mappers.UserMapper;
import balashov.os.synchronizeratingbot.infrastructure.jpa.common.repositories.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminAdaptersFactory {
    MemberRepository repository;
    ChatMapper chatMapper;
    UserMapper userMapper;
    MemberMapper mapper;

    @Bean
    public CheckAdminRole checkSavedAdminRole(MemberRepository memberRepository) {
        return (chat, user) -> memberRepository.findByChatAndUserAndStatusIn(chatMapper.mapToEntity(chat),
                userMapper.mapToEntity(user), MemberStatuses.admins()).isPresent();
    }

    @Bean
    public GetAdministeredChats getAdministeredChannels(MemberRepository memberRepository) {
        return user -> memberRepository.findByUserAndStatusIn(userMapper.mapToEntity(user), MemberStatuses.admins())
                .stream()
                .map(MemberEntity::getChat)
                .map(chatMapper::mapToDto)
                .toList();
    }

    @Bean
    public GetChatAdmins getSavedChannelAdmins(MemberRepository memberRepository) {
        return chat -> memberRepository.findByChatAndStatusIn(chatMapper.mapToEntity(chat), MemberStatuses.admins())
                .stream()
                .map(mapper::mapToDto)
                .toList();
    }
}

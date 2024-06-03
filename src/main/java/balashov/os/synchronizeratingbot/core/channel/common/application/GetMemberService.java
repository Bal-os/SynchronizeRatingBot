package balashov.os.synchronizeratingbot.core.channel.common.application;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.MemberDto;
import balashov.os.synchronizeratingbot.core.channel.common.ports.repository.SaveMemberRepository;
import balashov.os.synchronizeratingbot.core.channel.common.ports.usecases.GetMember;
import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.ChatDto;
import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetMemberService implements GetMember {
    private final GetMember getSavedChatMember;
    private final GetMember getMemberProvider;
    private final SaveMemberRepository saveChatMember;

    public Optional<MemberDto> getChatMemberByChatAndUser(ChatDto chat, UserDto user) {
        var savedChatMember = getSavedChatMember.getChatMemberByChatAndUser(chat, user);
        var provideChatMember = getMemberProvider.getChatMemberByChatAndUser(chat, user);

        if (provideChatMember.isPresent() &&
                (savedChatMember.isEmpty() || !savedChatMember.equals(provideChatMember))) {
            saveChatMember.saveChatMember(provideChatMember.get());
        }
        return provideChatMember;
    }
}

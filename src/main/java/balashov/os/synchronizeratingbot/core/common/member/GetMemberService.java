package balashov.os.synchronizeratingbot.core.common.member;

import balashov.os.synchronizeratingbot.core.common.chat.ports.ChatDto;
import balashov.os.synchronizeratingbot.core.common.member.ports.GetMember;
import balashov.os.synchronizeratingbot.core.common.member.ports.MemberDto;
import balashov.os.synchronizeratingbot.core.common.member.ports.SaveMemberRepository;
import balashov.os.synchronizeratingbot.core.common.user.ports.UserDto;
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

package balashov.os.synchronizeratingbot.core.channel.memberstatus.application;

import balashov.os.synchronizeratingbot.core.channel.memberstatus.ports.entities.MemberStatuses;
import balashov.os.synchronizeratingbot.core.channel.memberstatus.ports.usecases.CheckChatMembership;
import balashov.os.synchronizeratingbot.core.channel.common.ports.usecases.GetMember;
import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.ChatDto;
import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.UserDto;
import balashov.os.synchronizeratingbot.core.channel.memberstatus.ports.usecases.GetUserStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckMembershipService implements CheckChatMembership {
    private final GetUserStatus getUserStatusService;
    private final CheckChatMembership checkSavedChatMembership;
    private final CheckChatMembership checkChatMembershipProvider;

    @Override
    public boolean isUserMember(ChatDto chat, UserDto user) {
        var savedChatMembership = checkSavedChatMembership.isUserMember(chat, user);
        var provideChatMembership = checkChatMembershipProvider.isUserMember(chat, user);

        if (provideChatMembership != savedChatMembership) {
            return getUserStatusService.getStatus(chat, user)
                    .filter(MemberStatuses::isMember)
                    .isPresent();
        }
        return provideChatMembership;
    }

}

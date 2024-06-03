package balashov.os.synchronizeratingbot.core.channel.memberstatus.application;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.ChatDto;
import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.UserDto;
import balashov.os.synchronizeratingbot.core.channel.memberstatus.ports.entities.MemberStatuses;
import balashov.os.synchronizeratingbot.core.channel.memberstatus.ports.usecases.CheckAdminRole;
import balashov.os.synchronizeratingbot.core.channel.memberstatus.ports.usecases.GetUserStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckAdminRoleService implements CheckAdminRole {
    private final GetUserStatus getUserStatusService;
    private final CheckAdminRole checkSavedAdminRole;
    private final CheckAdminRole checkAdminRoleProvider;

    @Override
    public boolean isUserAdmin(ChatDto chat, UserDto user) {
        var savedAdminRole = checkSavedAdminRole.isUserAdmin(chat, user);
        var providedAdminRole = checkAdminRoleProvider.isUserAdmin(chat, user);

        if (providedAdminRole != savedAdminRole) {
            return getUserStatusService.getStatus(chat, user)
                    .filter(MemberStatuses::isAdmin)
                    .isPresent();
        }
        return providedAdminRole;
    }
}

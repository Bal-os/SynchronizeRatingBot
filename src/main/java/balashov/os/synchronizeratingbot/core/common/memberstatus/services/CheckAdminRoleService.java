package balashov.os.synchronizeratingbot.core.common.memberstatus.services;

import balashov.os.synchronizeratingbot.core.common.chat.ports.ChatDto;
import balashov.os.synchronizeratingbot.core.common.memberstatus.ports.entities.MemberStatuses;
import balashov.os.synchronizeratingbot.core.common.memberstatus.ports.usecases.CheckAdminRole;
import balashov.os.synchronizeratingbot.core.common.memberstatus.ports.usecases.GetUserStatus;
import balashov.os.synchronizeratingbot.core.common.user.ports.UserDto;
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

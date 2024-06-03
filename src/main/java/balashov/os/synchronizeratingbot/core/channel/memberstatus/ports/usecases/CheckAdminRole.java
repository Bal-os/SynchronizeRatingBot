package balashov.os.synchronizeratingbot.core.channel.memberstatus.ports.usecases;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.ChatDto;
import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.UserDto;

public interface CheckAdminRole {
    boolean isUserAdmin(ChatDto chat, UserDto user);
}

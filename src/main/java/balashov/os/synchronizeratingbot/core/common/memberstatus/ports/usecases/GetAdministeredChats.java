package balashov.os.synchronizeratingbot.core.common.memberstatus.ports.usecases;

import balashov.os.synchronizeratingbot.core.common.chat.ports.ChatDto;
import balashov.os.synchronizeratingbot.core.common.user.ports.UserDto;

import java.util.List;

public interface GetAdministeredChats {
    List<ChatDto> getAdministeredChats(UserDto user);
}

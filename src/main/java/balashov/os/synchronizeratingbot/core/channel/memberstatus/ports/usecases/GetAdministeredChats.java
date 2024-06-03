package balashov.os.synchronizeratingbot.core.channel.memberstatus.ports.usecases;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.ChatDto;
import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.UserDto;

import java.util.List;

public interface GetAdministeredChats {
    List<ChatDto> getAdministeredChats(UserDto user);
}

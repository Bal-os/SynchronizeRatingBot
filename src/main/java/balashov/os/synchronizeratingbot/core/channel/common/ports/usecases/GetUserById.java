package balashov.os.synchronizeratingbot.core.channel.common.ports.usecases;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.UserDto;

import java.util.Optional;

public interface GetUserById {
    Optional<UserDto> getUser(long userId);
}

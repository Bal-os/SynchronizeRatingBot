package balashov.os.synchronizeratingbot.core.common.usecases;

import balashov.os.synchronizeratingbot.core.common.entities.UserDto;

public interface GetUserById {
    UserDto getUser(long userId);
}

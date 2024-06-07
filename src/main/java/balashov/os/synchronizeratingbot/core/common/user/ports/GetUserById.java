package balashov.os.synchronizeratingbot.core.common.user.ports;

import java.util.Optional;

public interface GetUserById {
    Optional<UserDto> getUser(long userId);
}

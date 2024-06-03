package balashov.os.synchronizeratingbot.core.channel.common.ports.repository;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.UserDto;

public interface SaveUserRepository {
    void saveUser(UserDto userDto);
}

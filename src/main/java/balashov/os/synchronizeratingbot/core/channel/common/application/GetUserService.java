package balashov.os.synchronizeratingbot.core.channel.common.application;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.UserDto;
import balashov.os.synchronizeratingbot.core.channel.common.ports.usecases.GetUserById;
import balashov.os.synchronizeratingbot.core.channel.common.ports.repository.SaveUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetUserService implements GetUserById {
    private final GetUserById getSavedUserById;
    private final GetUserById getUserByIdProvider;
    private final SaveUserRepository saveUser;

    @Override
    public Optional<UserDto> getUser(long userId) {
        var savedUser = getSavedUserById.getUser(userId);
        var user = getUserByIdProvider.getUser(userId);

        if (savedUser.isEmpty()) {
            user.ifPresent(saveUser::saveUser);
        }
        return user;
    }
}

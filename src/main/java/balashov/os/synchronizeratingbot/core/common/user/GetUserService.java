package balashov.os.synchronizeratingbot.core.common.user;

import balashov.os.synchronizeratingbot.core.common.user.ports.GetUserById;
import balashov.os.synchronizeratingbot.core.common.user.ports.SaveUserRepository;
import balashov.os.synchronizeratingbot.core.common.user.ports.UserDto;
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

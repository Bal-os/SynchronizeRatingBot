package balashov.os.synchronizeratingbot.infrastructure.jpa.common.adapters;

import balashov.os.synchronizeratingbot.core.common.user.ports.GetUserById;
import balashov.os.synchronizeratingbot.core.common.user.ports.SaveUserRepository;
import balashov.os.synchronizeratingbot.infrastructure.jpa.common.mappers.UserMapper;
import balashov.os.synchronizeratingbot.infrastructure.jpa.common.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UserAdaptersFactory {
    private final UserRepository repository;
    private final UserMapper mapper;

    @Bean
    public SaveUserRepository saveUserRepository() {
        return user -> repository.save(mapper.mapToEntity(user));
    }

    @Bean
    public GetUserById getSavedUserById() {
        return userId -> repository.findById(userId)
                .map(mapper::mapToDto);
    }
}

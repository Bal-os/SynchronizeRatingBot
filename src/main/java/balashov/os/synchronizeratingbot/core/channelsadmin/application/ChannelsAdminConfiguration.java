package balashov.os.synchronizeratingbot.core.channelsadmin.application;

import balashov.os.synchronizeratingbot.core.channelsadmin.ports.entities.AdminDto;
import balashov.os.synchronizeratingbot.core.channelsadmin.ports.repositories.GetUserStatusRepository;
import balashov.os.synchronizeratingbot.core.channelsadmin.ports.repositories.SaveUserStatusRepository;
import balashov.os.synchronizeratingbot.core.channelsadmin.ports.usecases.CheckAdminRole;
import balashov.os.synchronizeratingbot.core.channelsadmin.ports.usecases.GetAdministeredChannels;
import balashov.os.synchronizeratingbot.core.channelsadmin.ports.usecases.GetUserStatus;
import balashov.os.synchronizeratingbot.core.channelsadmin.ports.usecases.SaveUserStatus;
import balashov.os.synchronizeratingbot.core.common.usecases.GetUserById;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.Optional;

@Configuration
public class ChannelsAdminConfiguration {
    @Bean
    public GetUserStatus getUserStatus(GetUserStatus getUserStatus,
                                       GetUserStatusRepository getUserStatusRepository,
                                       SaveUserStatusRepository saveUserStatusRepository) {
        return (chatId, userId) -> Optional.ofNullable(getUserStatus.getStatus(chatId, userId))
                .stream()
                .peek(status -> saveUserStatusRepository.save(chatId, userId, status))
                .findAny()
                .or(() -> getUserStatusRepository.getStatus(chatId, userId))
                .orElseThrow();
    }

    @Bean
    public SaveUserStatus saveUserStatus(SaveUserStatusRepository saveUserStatusRepository) {
        return saveUserStatusRepository::save;
    }
}

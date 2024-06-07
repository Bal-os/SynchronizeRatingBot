package balashov.os.synchronizeratingbot.infrastructure.telegram.common.adapters.services;

import balashov.os.synchronizeratingbot.core.common.user.ports.GetUserById;
import balashov.os.synchronizeratingbot.core.common.user.ports.UserDto;
import balashov.os.synchronizeratingbot.infrastructure.telegram.common.adapters.mappers.TelegramPhotoMapper;
import balashov.os.synchronizeratingbot.infrastructure.telegram.common.adapters.mappers.TelegramUserMapper;
import balashov.os.synchronizeratingbot.infrastructure.telegram.common.application.services.TelegramClientProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.GetUserProfilePhotos;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChat;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.UserProfilePhotos;

import java.util.Collection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetUserByIdProvider implements GetUserById {
    private final TelegramClientProxy telegramClient;
    private final TelegramUserMapper mapper;
    private final TelegramPhotoMapper photoMapper;

    @Override
    public Optional<UserDto> getUser(long userId) {
        return Optional.of(GetChat.builder().chatId(userId).build())
                .map(telegramClient::execute)
                .map(this::addPhoto);
    }

    private UserDto addPhoto(Chat userChat) {
        var getPhoto = GetUserProfilePhotos.builder()
                .userId(userChat.getId())
                .build();

        var photos = Optional.ofNullable(getPhoto)
                .map(telegramClient::execute)
                .map(UserProfilePhotos::getPhotos)
                .stream()
                .flatMap(Collection::stream)
                .flatMap(Collection::stream)
                .map(photoMapper::toDto)
                .toList();

        return mapper.toDtoWithPhotos(userChat, photos);
    }
}

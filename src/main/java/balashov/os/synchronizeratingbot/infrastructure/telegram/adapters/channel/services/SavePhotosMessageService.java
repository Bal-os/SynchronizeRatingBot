package balashov.os.synchronizeratingbot.infrastructure.telegram.adapters.channel.services;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.MessageDto;
import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.PhotoDto;
import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.UserDto;
import balashov.os.synchronizeratingbot.core.channel.common.ports.usecases.SavePhotosMessage;
import balashov.os.synchronizeratingbot.infrastructure.telegram.adapters.channel.mappers.TelegramMessageMapper;
import balashov.os.synchronizeratingbot.infrastructure.telegram.executors.TelegramClientProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.objects.media.InputMediaPhoto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SavePhotosMessageService implements SavePhotosMessage {
    private final TelegramClientProxy telegramClientProxy;
    private final TelegramMessageMapper telegramMessageMapper;
    @Value("${telegram.bot.photo-chat}")
    private String photoChat;

    @Override
    public List<MessageDto> savePhotos(List<PhotoDto> photos) {
        var sendPhotos = photos.stream()
                .map(this::toSendPhoto)
                .toList();
        var mediaGroup = SendMediaGroup.builder()
                .chatId(photoChat)
                .medias(sendPhotos)
                .build();
        var messages = telegramClientProxy.execute(mediaGroup);
        return messages.stream()
                .map(telegramMessageMapper::toDto)
                .toList();
    }

    private InputMediaPhoto toSendPhoto(PhotoDto photoDto) {
        return InputMediaPhoto.builder()
                .media(photoDto.id())
                .caption(getPhotoCaption(photoDto.photoAuthor()))
                .build();
    }

    private String getPhotoCaption(UserDto user) {
        return "Photo saved by bot from user %s chat, with id: %d".formatted(user.username(), user.id());
    }
}

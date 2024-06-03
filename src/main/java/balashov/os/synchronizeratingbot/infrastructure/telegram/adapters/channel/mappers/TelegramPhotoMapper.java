package balashov.os.synchronizeratingbot.infrastructure.telegram.adapters.channel.mappers;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.PhotoDto;
import org.mapstruct.Mapper;
import org.telegram.telegrambots.meta.api.objects.File;
import org.telegram.telegrambots.meta.api.objects.PhotoSize;

@Mapper(componentModel = "spring")
public interface TelegramPhotoMapper {
    default PhotoDto toDto(PhotoSize telegramPhoto) {
        return PhotoDto.builder()
                .id(telegramPhoto.getFileId())
                .fileUniqueId(telegramPhoto.getFileUniqueId())
                .filePath(telegramPhoto.getFilePath())
                .build();
    }

    default PhotoDto toDto(File telegramPhoto) {
        return PhotoDto.builder()
                .id(telegramPhoto.getFileId())
                .filePath(telegramPhoto.getFilePath())
                .fileUniqueId(telegramPhoto.getFileUniqueId())
                .build();
    }
}

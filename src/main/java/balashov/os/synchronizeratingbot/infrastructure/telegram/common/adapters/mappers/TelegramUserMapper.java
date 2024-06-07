package balashov.os.synchronizeratingbot.infrastructure.telegram.common.adapters.mappers;

import balashov.os.synchronizeratingbot.core.common.photo.ports.PhotoDto;
import balashov.os.synchronizeratingbot.core.common.user.ports.UserDto;
import org.mapstruct.Mapper;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TelegramUserMapper {
    default UserDto toDto(Chat userChat) {
        return UserDto.builder()
                .id(userChat.getId())
                .firstName(userChat.getFirstName())
                .lastName(userChat.getLastName())
                .username(userChat.getUserName())
                .build();
    }

    default UserDto toDtoWithPhotos(Chat userChat, List<PhotoDto> photosDto) {
        return UserDto.builder()
                .id(userChat.getId())
                .firstName(userChat.getFirstName())
                .lastName(userChat.getLastName())
                .username(userChat.getUserName())
                .profilePhotos(photosDto)
                .build();
    }

    default UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUserName())
                .isBot(user.getIsBot())
                .languageCode(user.getLanguageCode())
                .build();
    }

    default UserDto toDtoWithPhotos(User user, List<PhotoDto> photosDto) {
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .username(user.getUserName())
                .isBot(user.getIsBot())
                .languageCode(user.getLanguageCode())
                .profilePhotos(photosDto)
                .build();
    }

    default User fromDto(UserDto dto) {
        return User.builder()
                .id(dto.id())
                .firstName(dto.firstName())
                .lastName(dto.lastName())
                .userName(dto.username())
                .isBot(dto.isBot())
                .languageCode(dto.languageCode())
                .build();
    }
}

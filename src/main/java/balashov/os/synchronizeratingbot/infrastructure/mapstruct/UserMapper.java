package balashov.os.synchronizeratingbot.infrastructure.mapstruct;

import balashov.os.synchronizeratingbot.infrastructure.sql.entities.UserEntity;
import balashov.os.synchronizeratingbot.infrastructure.telegram.entities.TelegramUserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "userName", source = "userName")
    @Mapping(target = "isBot", source = "isBot")
    @Mapping(target = "languageCode", source = "languageCode")
    TelegramUserDto mapToDto(UserEntity user);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "userName", source = "userName")
    @Mapping(target = "isBot", source = "isBot")
    @Mapping(target = "languageCode", source = "languageCode")
    UserEntity mapToUser(TelegramUserDto user);
}

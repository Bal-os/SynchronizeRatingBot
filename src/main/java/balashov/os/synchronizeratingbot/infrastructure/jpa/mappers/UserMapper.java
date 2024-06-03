package balashov.os.synchronizeratingbot.infrastructure.jpa.mappers;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.UserDto;
import balashov.os.synchronizeratingbot.infrastructure.jpa.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto mapToDto(UserEntity userEntity);

    UserEntity mapToEntity(UserDto userDto);
}
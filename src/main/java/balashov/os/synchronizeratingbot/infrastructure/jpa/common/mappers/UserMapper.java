package balashov.os.synchronizeratingbot.infrastructure.jpa.common.mappers;

import balashov.os.synchronizeratingbot.core.common.user.ports.UserDto;
import balashov.os.synchronizeratingbot.infrastructure.jpa.common.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto mapToDto(UserEntity userEntity);

    UserEntity mapToEntity(UserDto userDto);
}
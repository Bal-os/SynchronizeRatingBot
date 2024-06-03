package balashov.os.synchronizeratingbot.infrastructure.jpa.mappers;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.PhotoDto;
import balashov.os.synchronizeratingbot.infrastructure.jpa.entities.PhotoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhotoMapper {
    PhotoDto mapToDto(PhotoEntity photoEntity);
    PhotoEntity mapToEntity(PhotoDto photoDto);
}
package balashov.os.synchronizeratingbot.infrastructure.jpa.common.mappers;

import balashov.os.synchronizeratingbot.core.common.photo.ports.PhotoDto;
import balashov.os.synchronizeratingbot.infrastructure.jpa.common.entities.PhotoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhotoMapper {
    PhotoDto mapToDto(PhotoEntity photoEntity);

    PhotoEntity mapToEntity(PhotoDto photoDto);
}
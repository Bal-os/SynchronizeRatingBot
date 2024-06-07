package balashov.os.synchronizeratingbot.infrastructure.jpa.common.mappers;

import balashov.os.synchronizeratingbot.core.common.message.ports.MessageDto;
import balashov.os.synchronizeratingbot.infrastructure.jpa.common.entities.MessageEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    MessageDto mapToDto(MessageEntity messageEntity);

    MessageEntity mapToEntity(MessageDto messageDto);
}
package balashov.os.synchronizeratingbot.infrastructure.jpa.mappers;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.MessageDto;
import balashov.os.synchronizeratingbot.infrastructure.jpa.entities.MessageEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    MessageDto mapToDto(MessageEntity messageEntity);
    MessageEntity mapToEntity(MessageDto messageDto);
}
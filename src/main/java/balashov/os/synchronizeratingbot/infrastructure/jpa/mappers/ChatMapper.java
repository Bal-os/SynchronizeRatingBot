package balashov.os.synchronizeratingbot.infrastructure.jpa.mappers;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.ChatDto;
import balashov.os.synchronizeratingbot.infrastructure.jpa.entities.ChatEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChatMapper {
    ChatDto mapToDto(ChatEntity chatEntity);

    ChatEntity mapToEntity(ChatDto chatDto);
}
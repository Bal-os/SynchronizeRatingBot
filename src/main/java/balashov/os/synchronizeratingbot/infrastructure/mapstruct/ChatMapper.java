package balashov.os.synchronizeratingbot.infrastructure.mapstruct;

import balashov.os.synchronizeratingbot.infrastructure.sql.entities.ChatEntity;
import balashov.os.synchronizeratingbot.infrastructure.telegram.entities.TelegramChatDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ChatMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "isChannelChat", source = "isChannel")
    TelegramChatDto mapToDto(ChatEntity chatEntity);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "isChannel", source = "isChannelChat")
    ChatEntity mapToChat(TelegramChatDto chatDto);
}
package balashov.os.synchronizeratingbot.infrastructure.mapstruct;

import balashov.os.synchronizeratingbot.infrastructure.sql.entities.MessageEntity;
import balashov.os.synchronizeratingbot.infrastructure.telegram.entities.TelegramMessageDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    @Mapping(target = "messageId", source = "id.id")
    @Mapping(target = "from", source = "from")
    @Mapping(target = "date", source = "date")
    @Mapping(target = "chat", source = "chat")
    @Mapping(target = "forwardFrom", source = "forwardFrom")
    @Mapping(target = "forwardFromChat", source = "forwardFromChat")
    @Mapping(target = "text", source = "text")
    TelegramMessageDto mapToDto(MessageEntity message);

    @Mapping(target = "id.id", source = "messageId")
    @Mapping(target = "from", source = "from")
    @Mapping(target = "date", source = "date")
    @Mapping(target = "chat", source = "chat")
    @Mapping(target = "forwardFrom", source = "forwardFrom")
    @Mapping(target = "forwardFromChat", source = "forwardFromChat")
    @Mapping(target = "text", source = "text")
    MessageEntity mapToMessage(TelegramMessageDto message);
}

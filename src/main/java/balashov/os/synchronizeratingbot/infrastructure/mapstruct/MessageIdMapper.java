package balashov.os.synchronizeratingbot.infrastructure.mapstruct;

import balashov.os.synchronizeratingbot.core.common.entities.MessageId;
import balashov.os.synchronizeratingbot.infrastructure.sql.entities.MessageKey;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MessageIdMapper {
    @Mapping(target = "messageId", source = "messageId")
    @Mapping(target = "chatId", source = "chatId")
    MessageId mapToMessageId(MessageKey messageKey);

    @Mapping(target = "messageId", source = "messageId")
    @Mapping(target = "chatId", source = "chatId")
    MessageKey mapToMessageKey(MessageId messageId);
}

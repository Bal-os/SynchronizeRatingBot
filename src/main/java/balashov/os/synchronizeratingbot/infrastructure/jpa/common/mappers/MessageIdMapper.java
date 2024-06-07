package balashov.os.synchronizeratingbot.infrastructure.jpa.common.mappers;

import balashov.os.synchronizeratingbot.core.common.message.ports.MessageId;
import balashov.os.synchronizeratingbot.infrastructure.jpa.common.entities.MessageKey;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageIdMapper {
    MessageId mapToMessageId(MessageKey messageKey);

    MessageKey mapToMessageKey(MessageId messageId);
}

package balashov.os.synchronizeratingbot.infrastructure.jpa.mappers;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.MessageId;
import balashov.os.synchronizeratingbot.infrastructure.jpa.entities.MessageKey;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageIdMapper {
    MessageId mapToMessageId(MessageKey messageKey);

    MessageKey mapToMessageKey(MessageId messageId);
}

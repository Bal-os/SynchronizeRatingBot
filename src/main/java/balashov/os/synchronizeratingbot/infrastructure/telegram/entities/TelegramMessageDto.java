package balashov.os.synchronizeratingbot.infrastructure.telegram.entities;

import balashov.os.synchronizeratingbot.core.common.entities.MessageDto;
import balashov.os.synchronizeratingbot.core.common.entities.MessageId;
import lombok.experimental.SuperBuilder;
import org.telegram.telegrambots.meta.api.objects.message.Message;

@SuperBuilder
public class TelegramMessageDto extends Message implements MessageDto {
    @Override
    public MessageId id() {
        return new MessageId(getMessageId(), getChatId());
    }
}

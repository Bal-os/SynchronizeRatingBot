package balashov.os.synchronizeratingbot.core.common.message.ports;

import java.util.Optional;

public interface GetMessageById {
    Optional<MessageDto> getMessage(MessageId messageId);
}

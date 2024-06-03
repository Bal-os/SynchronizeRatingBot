package balashov.os.synchronizeratingbot.core.channel.common.ports.usecases;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.MessageDto;
import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.MessageId;

import java.util.Optional;

public interface GetMessageById {
    Optional<MessageDto> getMessage(MessageId messageId);
}

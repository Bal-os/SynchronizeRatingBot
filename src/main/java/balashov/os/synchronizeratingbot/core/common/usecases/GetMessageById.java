package balashov.os.synchronizeratingbot.core.common.usecases;

import balashov.os.synchronizeratingbot.core.common.entities.MessageDto;
import balashov.os.synchronizeratingbot.core.common.entities.MessageId;

public interface GetMessageById {
    MessageDto getMessage(MessageId messageId);
}

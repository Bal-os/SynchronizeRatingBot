package balashov.os.synchronizeratingbot.core.common.usecases;

import balashov.os.synchronizeratingbot.core.common.entities.MessageDto;

public interface SaveMessageDto {
    void saveMessage(MessageDto messageDto);
}

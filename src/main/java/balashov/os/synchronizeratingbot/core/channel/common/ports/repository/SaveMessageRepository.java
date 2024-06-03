package balashov.os.synchronizeratingbot.core.channel.common.ports.repository;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.MessageDto;

public interface SaveMessageRepository {
    void saveMessage(MessageDto messageDto);
}

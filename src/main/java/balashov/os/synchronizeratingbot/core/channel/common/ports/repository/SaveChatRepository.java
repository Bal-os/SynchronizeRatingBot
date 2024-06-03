package balashov.os.synchronizeratingbot.core.channel.common.ports.repository;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.ChatDto;

public interface SaveChatRepository {
    void saveChat(ChatDto chatDto);
}

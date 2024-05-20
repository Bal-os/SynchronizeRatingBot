package balashov.os.synchronizeratingbot.core.common.usecases;

import balashov.os.synchronizeratingbot.core.common.entities.ChatDto;

public interface SaveChatDto {
    void saveChat(ChatDto chatDto);
}

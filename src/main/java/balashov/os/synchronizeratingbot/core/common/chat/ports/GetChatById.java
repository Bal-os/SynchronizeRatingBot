package balashov.os.synchronizeratingbot.core.common.chat.ports;

import java.util.Optional;

public interface GetChatById {
    Optional<ChatDto> getChat(long chatId);
}

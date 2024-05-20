package balashov.os.synchronizeratingbot.infrastructure.telegram.hendlers;

import org.telegram.telegrambots.meta.api.objects.message.Message;

public interface PhotoHandler {
    default boolean canHandle(Message message) {
        return message.hasPhoto();
    }

    void handleMessage(Message message);
}

package balashov.os.synchronizeratingbot.infrastructure.telegram.common.application.hendlers;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.message.Message;

public interface MessageHandler extends UpdateHandler {
    default boolean canHandle(Update update) {
        return update.hasMessage();
    }

    default void handleUpdate(Update update) {
        handleMessage(update.getMessage());
    }

    void handleMessage(Message message);
}

package balashov.os.synchronizeratingbot.infrastructure.telegram.listeners.hendlers.personal;

import balashov.os.synchronizeratingbot.infrastructure.telegram.listeners.hendlers.MessageHandler;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface PersonalMessageHandler extends MessageHandler {
    @Override
    default boolean canHandle(Update update) {
        return MessageHandler.super.canHandle(update) &&
                update.getMessage().isUserMessage();
    }
}

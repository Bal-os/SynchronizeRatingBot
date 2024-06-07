package balashov.os.synchronizeratingbot.infrastructure.telegram.common.application.hendlers;

import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface CallbackHandler extends UpdateHandler {
    @Override
    default boolean canHandle(Update update) {
        return update.hasCallbackQuery();
    }

    @Override
    default void handleUpdate(Update update) {
        handleCallback(update.getCallbackQuery());
    }

    void handleCallback(CallbackQuery callbackQuery);
}

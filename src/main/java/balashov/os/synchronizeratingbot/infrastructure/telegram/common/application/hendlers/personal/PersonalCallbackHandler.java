package balashov.os.synchronizeratingbot.infrastructure.telegram.common.application.hendlers.personal;

import balashov.os.synchronizeratingbot.infrastructure.telegram.common.application.hendlers.CallbackHandler;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface PersonalCallbackHandler extends CallbackHandler {
    @Override
    default boolean canHandle(Update update) {
        return CallbackHandler.super.canHandle(update) &&
                update.getCallbackQuery().getMessage().getChat().isUserChat();
    }
}

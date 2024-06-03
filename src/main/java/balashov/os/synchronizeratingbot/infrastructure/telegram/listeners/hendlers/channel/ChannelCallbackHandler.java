package balashov.os.synchronizeratingbot.infrastructure.telegram.listeners.hendlers.channel;

import balashov.os.synchronizeratingbot.infrastructure.telegram.listeners.hendlers.CallbackHandler;
import balashov.os.synchronizeratingbot.infrastructure.telegram.listeners.hendlers.UpdateHandler;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface ChannelCallbackHandler extends CallbackHandler {
    @Override
    default boolean canHandle(Update update) {
        return CallbackHandler.super.canHandle(update) &&
                update.getCallbackQuery().getMessage().getChat().isChannelChat();
    }
}

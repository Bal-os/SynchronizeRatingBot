package balashov.os.synchronizeratingbot.infrastructure.telegram.common.application.hendlers.personal;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface PersonalNonCommandMessageHandler extends PersonalMessageHandler {
    @Override
    default boolean canHandle(Update update) {
        return PersonalMessageHandler.super.canHandle(update) &&
                !update.getMessage().isCommand();
    }
}

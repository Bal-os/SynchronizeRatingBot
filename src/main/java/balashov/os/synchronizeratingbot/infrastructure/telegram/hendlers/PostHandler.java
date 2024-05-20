package balashov.os.synchronizeratingbot.infrastructure.telegram.hendlers;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.message.Message;

public interface PostHandler {
    default boolean canHandle(Update update) {
        return update.hasChannelPost();
    }

    default void handleUpdate(Update update) {
        handlePost(update.getChannelPost());
    }

    void handlePost(Message channelPost);
}

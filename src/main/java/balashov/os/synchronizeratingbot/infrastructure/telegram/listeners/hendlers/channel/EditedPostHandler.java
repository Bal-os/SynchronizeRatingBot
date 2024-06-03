package balashov.os.synchronizeratingbot.infrastructure.telegram.listeners.hendlers.channel;

import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.message.Message;

public interface EditedPostHandler {
    default boolean canHandle(Update update) {
        return update.hasEditedChannelPost();
    }

    default void handleUpdate(Update update) {
        handleEditedPost(update.getEditedChannelPost());
    }

    void handleEditedPost(Message editedChannelPost);
}

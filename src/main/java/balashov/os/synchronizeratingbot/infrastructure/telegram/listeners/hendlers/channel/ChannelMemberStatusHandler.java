package balashov.os.synchronizeratingbot.infrastructure.telegram.listeners.hendlers.channel;

import balashov.os.synchronizeratingbot.infrastructure.telegram.listeners.hendlers.UpdateHandler;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.chatmember.ChatMemberUpdated;

public interface ChannelMemberStatusHandler extends UpdateHandler {
    @Override
    default boolean canHandle(Update update) {
        return update.hasChatMember() && update.getChatMember().getChat().isChannelChat();
    }

    @Override
    default void handleUpdate(Update update) {
        handleChatMemberStatus(update.getChatMember());
    }

    void handleChatMemberStatus(ChatMemberUpdated chatMemberUpdate);
}

package balashov.os.synchronizeratingbot.infrastructure.telegram.common.application.hendlers.channel;

import balashov.os.synchronizeratingbot.infrastructure.telegram.common.application.hendlers.UpdateHandler;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.chatmember.ChatMemberUpdated;

public interface ChannelBotStatusHandler extends UpdateHandler {
    @Override
    default boolean canHandle(Update update) {
        return update.hasMyChatMember() && update.getMyChatMember().getChat().isChannelChat();
    }

    @Override
    default void handleUpdate(Update update) {
        handleBotStatus(update.getMyChatMember());
    }

    void handleBotStatus(ChatMemberUpdated chatMemberUpdate);
}

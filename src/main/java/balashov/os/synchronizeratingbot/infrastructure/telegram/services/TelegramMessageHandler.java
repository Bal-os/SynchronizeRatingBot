package balashov.os.synchronizeratingbot.infrastructure.telegram.services;

import balashov.os.synchronizeratingbot.infrastructure.telegram.hendlers.MessageHandler;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.message.Message;

public class TelegramMessageHandler implements MessageHandler {

    @Override
    public void handleMessage(Message message) {
        Chat chat = message.getChat();
        User user = message.getFrom();

        if (!user.getId().equals(chat.getId())) {
            return;
        }


    }
}

package balashov.os.synchronizeratingbot.infrastructure.telegram.common.application.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.meta.api.methods.botapimethods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMediaGroup;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.io.Serializable;
import java.util.List;

@Slf4j
@Service
public class TelegramClientProxy extends OkHttpTelegramClient implements TelegramClient {
    public TelegramClientProxy(@Value("${telegram.bot.token}") String botToken) {
        super(botToken);
    }

    @Override
    public <T extends Serializable, Method extends BotApiMethod<T>> T execute(Method method) {
        try {
            return super.execute(method);
        } catch (TelegramApiException e) {
            log.error("Telegram client executor: Error while executing method", e);
            return null;
        }
    }

    @Override
    public Message execute(SendPhoto sendPhoto) {
        try {
            return executeAsync(sendPhoto).get();
        } catch (Exception e) {
            log.error("Telegram client executor: Error while executing method", e);
            return null;
        }
    }

    @Override
    public List<Message> execute(SendMediaGroup sendMediaGroup) {
        try {
            return executeAsync(sendMediaGroup).get();
        } catch (Exception e) {
            log.error("Telegram client executor: Error while executing method", e);
            return null;
        }
    }
}

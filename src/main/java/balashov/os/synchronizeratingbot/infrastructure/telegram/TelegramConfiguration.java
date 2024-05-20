package balashov.os.synchronizeratingbot.infrastructure.telegram;

import balashov.os.synchronizeratingbot.infrastructure.telegram.hendlers.UpdateHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.interfaces.LongPollingUpdateConsumer;
import org.telegram.telegrambots.longpolling.starter.SpringLongPollingBot;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.util.List;

@Configuration
public class TelegramConfiguration {
    private @Value("${telegram.bot.token}") String botToken;
    @Bean
    public SpringLongPollingBot springLongPollingBot(LongPollingUpdateConsumer updateConsumer) {
        return new SpringLongPollingBot() {
            @Override
            public String getBotToken() {
                return botToken;
            }

            @Override
            public LongPollingUpdateConsumer getUpdatesConsumer() {
                return updateConsumer;
            }
        };
    }

    @Bean
    public LongPollingSingleThreadUpdateConsumer updateConsumer(List<UpdateHandler> updateHandlers) {
        return (update) -> updateHandlers.stream()
                .filter(handler -> handler.canHandle(update))
                .findFirst()
                .ifPresent(handler -> handler.handleUpdate(update));
    }

    @Bean
    public TelegramClient telegramClient() {
        return new OkHttpTelegramClient(botToken);
    }
}

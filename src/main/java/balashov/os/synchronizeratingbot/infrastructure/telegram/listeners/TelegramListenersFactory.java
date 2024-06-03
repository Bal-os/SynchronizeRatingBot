package balashov.os.synchronizeratingbot.infrastructure.telegram.listeners;

import balashov.os.synchronizeratingbot.infrastructure.telegram.listeners.hendlers.UpdateHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.longpolling.interfaces.LongPollingUpdateConsumer;
import org.telegram.telegrambots.longpolling.starter.SpringLongPollingBot;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;

import java.util.List;

@Slf4j
@Configuration
public class TelegramListenersFactory {

    @Value("${telegram.bot.token}")
    private String botToken;

    @Bean
    public SpringLongPollingBot longPollingBot(LongPollingUpdateConsumer dispatcher) {
        return new SpringLongPollingBot() {
            @Override
            public String getBotToken() {
                return botToken;
            }

            @Override
            public LongPollingUpdateConsumer getUpdatesConsumer() {
                return dispatcher;
            }
        };
    }

    @Bean
    public LongPollingSingleThreadUpdateConsumer dispatcher (List<UpdateHandler> updateHandlers) {
        return (update) -> updateHandlers.stream()
                .filter(handler -> handler.canHandle(update))
                .findFirst()
                .ifPresent(handler -> handler.handleUpdate(update));
    }
}


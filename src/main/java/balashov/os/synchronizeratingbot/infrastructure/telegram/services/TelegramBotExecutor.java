package balashov.os.synchronizeratingbot.infrastructure.telegram.services;

import balashov.os.synchronizeratingbot.infrastructure.telegram.usecases.BotExecutor;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChatMember;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.util.Optional;

@Slf4j
@Component
@AllArgsConstructor
public class TelegramBotExecutor implements BotExecutor {
    private final TelegramClient telegramClient;

    @Override
    public Optional<String> getMemberStatus(long chatId, long userId) {
        GetChatMember getChatMember = GetChatMember.builder()
                .chatId(String.valueOf(chatId))
                .userId(userId)
                .build();
        try {
            return Optional.of(telegramClient.execute(getChatMember).getStatus());
        } catch (TelegramApiException e) {
            log.error("Telegram client executor: Error while checking chat member", e);
        }
        return Optional.empty();
    }
}

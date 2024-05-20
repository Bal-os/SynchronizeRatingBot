package balashov.os.synchronizeratingbot.infrastructure.telegram.usecases;

import java.util.Optional;

public interface BotExecutor {
    Optional<String> getMemberStatus(long chatId, long userId);
}

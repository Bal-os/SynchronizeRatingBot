package balashov.os.synchronizeratingbot.infrastructure.telegram.entities;

import balashov.os.synchronizeratingbot.core.common.entities.ChatDto;
import lombok.experimental.SuperBuilder;
import org.telegram.telegrambots.meta.api.objects.Chat;

@SuperBuilder
public class TelegramChatDto extends Chat implements ChatDto {
    @Override
    public long id() {
        return getId();
    }
}

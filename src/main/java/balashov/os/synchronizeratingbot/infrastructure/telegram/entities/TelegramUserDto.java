package balashov.os.synchronizeratingbot.infrastructure.telegram.entities;

import balashov.os.synchronizeratingbot.core.common.entities.UserDto;
import lombok.experimental.SuperBuilder;
import org.telegram.telegrambots.meta.api.objects.User;

@SuperBuilder
public class TelegramUserDto extends User implements UserDto {
    @Override
    public long id() {
        return getId();
    }
}

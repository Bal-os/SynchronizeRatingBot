package balashov.os.synchronizeratingbot.infrastructure.telegram.entities;

import balashov.os.synchronizeratingbot.core.channelsadmin.ports.entities.MemberStatuses;
import lombok.Builder;
import lombok.Getter;
import org.telegram.telegrambots.meta.api.objects.chatmember.ChatMember;

@Builder
@Getter
public class TelegramChatMemberDto implements ChatMember {
    private final MemberStatuses status;
    private final TelegramUserDto user;
    private final TelegramChatDto chat;

    @Override
    public String getStatus() {
        return status.toString();
    }
}

package balashov.os.synchronizeratingbot.infrastructure.telegram.adapters.channel.mappers;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.MemberDto;
import balashov.os.synchronizeratingbot.core.channel.memberstatus.ports.entities.MemberStatuses;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.chatmember.ChatMember;

@Component
@RequiredArgsConstructor
public class TelegramMemberMapper {
    private final TelegramUserMapper telegramUserMapper;

    public MemberDto toDto(ChatMember chatMember) {
        return MemberDto.builder()
                .user(telegramUserMapper.toDto(chatMember.getUser()))
                .memberStatus(MemberStatuses.fromString(chatMember.getStatus()))
                .build();
    }
}

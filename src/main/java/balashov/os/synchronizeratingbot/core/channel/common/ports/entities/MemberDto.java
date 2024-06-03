package balashov.os.synchronizeratingbot.core.channel.common.ports.entities;

import balashov.os.synchronizeratingbot.core.channel.memberstatus.ports.entities.MemberStatuses;
import lombok.Builder;

@Builder
public record MemberDto(UserDto user,
                        ChatDto chat,
                        MemberStatuses memberStatus) {
}

package balashov.os.synchronizeratingbot.core.common.member.ports;

import balashov.os.synchronizeratingbot.core.common.chat.ports.ChatDto;
import balashov.os.synchronizeratingbot.core.common.memberstatus.ports.entities.MemberStatuses;
import balashov.os.synchronizeratingbot.core.common.user.ports.UserDto;
import lombok.Builder;

@Builder
public record MemberDto(UserDto user,
                        ChatDto chat,
                        MemberStatuses memberStatus) {
}

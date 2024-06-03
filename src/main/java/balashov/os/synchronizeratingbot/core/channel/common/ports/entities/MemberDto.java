package balashov.os.synchronizeratingbot.core.channel.common.ports.entities;

import balashov.os.synchronizeratingbot.core.channel.memberstatus.ports.entities.MemberStatuses;
import lombok.Builder;
import lombok.Getter;

@Builder
public record MemberDto(UserDto user,
                        ChatDto chat,
                        MemberStatuses memberStatus) {}

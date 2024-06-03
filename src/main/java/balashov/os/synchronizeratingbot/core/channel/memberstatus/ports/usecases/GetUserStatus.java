package balashov.os.synchronizeratingbot.core.channel.memberstatus.ports.usecases;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.ChatDto;
import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.UserDto;
import balashov.os.synchronizeratingbot.core.channel.memberstatus.ports.entities.MemberStatuses;

import java.util.Optional;

public interface GetUserStatus {
    Optional<MemberStatuses> getStatus(ChatDto chat, UserDto user);
}

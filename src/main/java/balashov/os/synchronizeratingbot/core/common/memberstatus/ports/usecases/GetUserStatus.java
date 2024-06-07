package balashov.os.synchronizeratingbot.core.common.memberstatus.ports.usecases;

import balashov.os.synchronizeratingbot.core.common.chat.ports.ChatDto;
import balashov.os.synchronizeratingbot.core.common.memberstatus.ports.entities.MemberStatuses;
import balashov.os.synchronizeratingbot.core.common.user.ports.UserDto;

import java.util.Optional;

public interface GetUserStatus {
    Optional<MemberStatuses> getStatus(ChatDto chat, UserDto user);
}

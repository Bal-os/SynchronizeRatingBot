package balashov.os.synchronizeratingbot.core.common.memberstatus.ports.usecases;

import balashov.os.synchronizeratingbot.core.common.chat.ports.ChatDto;
import balashov.os.synchronizeratingbot.core.common.user.ports.UserDto;

public interface CheckChatMembership {
    boolean isUserMember(ChatDto chat, UserDto user);
}

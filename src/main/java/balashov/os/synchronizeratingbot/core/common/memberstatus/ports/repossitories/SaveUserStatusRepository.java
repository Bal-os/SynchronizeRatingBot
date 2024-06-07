package balashov.os.synchronizeratingbot.core.common.memberstatus.ports.repossitories;

import balashov.os.synchronizeratingbot.core.common.chat.ports.ChatDto;
import balashov.os.synchronizeratingbot.core.common.memberstatus.ports.entities.MemberStatuses;
import balashov.os.synchronizeratingbot.core.common.user.ports.UserDto;

public interface SaveUserStatusRepository {
    void saveUserStatus(ChatDto chat, UserDto user, MemberStatuses status);
}

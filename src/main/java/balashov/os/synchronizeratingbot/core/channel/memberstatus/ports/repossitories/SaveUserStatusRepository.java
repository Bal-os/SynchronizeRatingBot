package balashov.os.synchronizeratingbot.core.channel.memberstatus.ports.repossitories;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.ChatDto;
import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.UserDto;
import balashov.os.synchronizeratingbot.core.channel.memberstatus.ports.entities.MemberStatuses;

public interface SaveUserStatusRepository {
    void saveUserStatus(ChatDto chat, UserDto user, MemberStatuses status);
}

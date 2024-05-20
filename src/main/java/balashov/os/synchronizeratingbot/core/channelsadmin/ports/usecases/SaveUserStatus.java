package balashov.os.synchronizeratingbot.core.channelsadmin.ports.usecases;

import balashov.os.synchronizeratingbot.core.channelsadmin.ports.entities.MemberStatuses;

public interface SaveUserStatus {
    void saveStatus(long chatId, long userId, MemberStatuses status);
}

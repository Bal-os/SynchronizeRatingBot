package balashov.os.synchronizeratingbot.core.channelsadmin.ports.usecases;

import balashov.os.synchronizeratingbot.core.channelsadmin.ports.entities.MemberStatuses;

public interface GetUserStatus {
    MemberStatuses getStatus(long chatId, long userId);
}

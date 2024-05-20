package balashov.os.synchronizeratingbot.core.channelsadmin.ports.repositories;

import balashov.os.synchronizeratingbot.core.channelsadmin.ports.entities.MemberStatuses;

public interface SaveUserStatusRepository {
    void save(long chatId, long userId, MemberStatuses status);
}

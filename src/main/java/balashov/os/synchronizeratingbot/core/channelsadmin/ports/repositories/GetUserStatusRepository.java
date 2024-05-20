package balashov.os.synchronizeratingbot.core.channelsadmin.ports.repositories;

import balashov.os.synchronizeratingbot.core.channelsadmin.ports.entities.MemberStatuses;

import java.util.Optional;

public interface GetUserStatusRepository {
    Optional<MemberStatuses> getStatus(long chatId, long userId);
}

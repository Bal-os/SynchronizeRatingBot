package balashov.os.synchronizeratingbot.core.eventschannel.ports.services;

import balashov.os.synchronizeratingbot.core.eventschannel.ports.entities.DigestPost;

public interface DigestService {
    DigestPost addEventToDigest(long digestId, long eventId);
    DigestPost removeEventFromDigest(long digestId, long eventId);
}

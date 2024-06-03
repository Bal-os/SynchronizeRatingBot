package balashov.os.synchronizeratingbot.core.eventposts.digest.ports.usecases;

import balashov.os.synchronizeratingbot.core.eventposts.digest.ports.entities.DigestPostContent;
import balashov.os.synchronizeratingbot.core.events.events.ports.entities.EventDto;

public interface AddEventToDigest {
    default DigestPostContent addEventToDigest(DigestPostContent digestPostContent, EventDto eventDto) {
        return digestPostContent.toBuilder().event(eventDto).build();
    }
}

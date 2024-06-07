package balashov.os.synchronizeratingbot.core.eventposts.ports.usecases;

import balashov.os.synchronizeratingbot.core.eventposts.ports.entities.DigestPostContent;
import balashov.os.synchronizeratingbot.core.events.events.ports.entities.EventDto;

public interface RemoveEventFromDigest {
    default DigestPostContent removeEventFromDigest(DigestPostContent digestPostContent, EventDto eventDto) {
        var builder = digestPostContent.toBuilder();
        digestPostContent.events().stream()
                .filter(event -> !event.equals(eventDto))
                .forEach(builder::event);
        return builder.build();
    }
}

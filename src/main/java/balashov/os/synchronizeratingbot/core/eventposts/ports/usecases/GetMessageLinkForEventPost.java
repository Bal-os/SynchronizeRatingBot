package balashov.os.synchronizeratingbot.core.eventposts.ports.usecases;

import balashov.os.synchronizeratingbot.core.events.events.ports.entities.EventDto;

public interface GetMessageLinkForEventPost {
    String getMessageLink(EventDto event);
}

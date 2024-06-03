package balashov.os.synchronizeratingbot.core.events.events.ports.usecases;

import balashov.os.synchronizeratingbot.core.events.events.ports.entities.EventDto;

public interface SaveEvent {
    EventDto saveEvent(EventDto eventDto);
}

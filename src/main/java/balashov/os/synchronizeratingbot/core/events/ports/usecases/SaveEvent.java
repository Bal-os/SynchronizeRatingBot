package balashov.os.synchronizeratingbot.core.events.ports.usecases;

import balashov.os.synchronizeratingbot.core.events.ports.entities.Event;

public interface SaveEvent {
    Event saveEvent(Event event);
}

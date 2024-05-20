package balashov.os.synchronizeratingbot.core.events.ports.usecases;

import balashov.os.synchronizeratingbot.core.events.ports.entities.Event;

public interface GetEvent {
    Event getEvent(long eventId);
}

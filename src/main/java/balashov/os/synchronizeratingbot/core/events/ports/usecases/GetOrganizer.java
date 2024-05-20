package balashov.os.synchronizeratingbot.core.events.ports.usecases;

import balashov.os.synchronizeratingbot.core.events.ports.entities.Organizer;

public interface GetOrganizer {
    Organizer getOrganizer(long organizerId);
}

package balashov.os.synchronizeratingbot.core.events.organizers.ports.usecases;

import balashov.os.synchronizeratingbot.core.events.organizers.ports.entities.OrganizerDto;

public interface SaveOrganizer {
    void saveOrganizer(OrganizerDto organizer);
}

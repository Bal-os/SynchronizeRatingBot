package balashov.os.synchronizeratingbot.core.events.events.ports.usecases;

import balashov.os.synchronizeratingbot.core.events.events.ports.entities.EventDto;
import balashov.os.synchronizeratingbot.core.events.organizers.ports.entities.OrganizerDto;

import java.time.LocalDate;
import java.util.List;

public interface GetEventsByDateAndOrganizer {
    List<EventDto> getEventsByDateAndOrganizer(LocalDate date, OrganizerDto organizer);
}

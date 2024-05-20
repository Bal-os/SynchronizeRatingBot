package balashov.os.synchronizeratingbot.core.events.ports.services;

import balashov.os.synchronizeratingbot.core.events.ports.entities.Event;

import java.time.LocalDate;
import java.util.List;

public interface GetEventsService {
    List<Event> getEventsByDate(LocalDate date);
    List<Event> getOrganizerEvents(long organizerId);
    List<Event> getEventsByDateAndOrganizer(LocalDate date, long organizerId);
}

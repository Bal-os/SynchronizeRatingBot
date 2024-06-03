package balashov.os.synchronizeratingbot.core.events.events.ports.usecases;

import balashov.os.synchronizeratingbot.core.events.events.ports.entities.EventDto;

import java.time.LocalDate;
import java.util.List;

public interface GetEventsByDate {
    List<EventDto> getEventsByDate(LocalDate date);
}

package balashov.os.synchronizeratingbot.core.eventposts.digest.application;

import balashov.os.synchronizeratingbot.core.eventposts.digest.ports.entities.DigestPostContent;
import balashov.os.synchronizeratingbot.core.eventposts.digest.ports.usecases.CreateDigestContent;
import balashov.os.synchronizeratingbot.core.events.events.ports.entities.EventDto;
import balashov.os.synchronizeratingbot.core.events.events.ports.usecases.GetEventsByDate;
import balashov.os.synchronizeratingbot.core.events.events.ports.usecases.GetEventsByDateRange;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class CreateDigestContentService implements CreateDigestContent {
    private final GetEventsByDateRange getEventsByDateRange;
    private final GetEventsByDate getEventsByDate;

    @Override
    public DigestPostContent createDigestPost(List<LocalDate> dates) {
        return null;
    }

    private List<EventDto> eventsByDates(List<LocalDate> dates) {
        if (isConsecutiveDates(dates)) {
            return getEventsByDateRange.getEventsByDateRange(dates.getFirst(), dates.getLast());
        }
        return dates.stream()
                .flatMap(this::eventsStreamByDate)
                .toList();
    }

    private boolean isConsecutiveDates(List<LocalDate> dates) {
        return dates.getLast().minusDays(dates.size()).isEqual(dates.getFirst());
    }

    private Stream<EventDto> eventsStreamByDate(LocalDate date) {
        return getEventsByDate.getEventsByDate(date).stream();
    }
}

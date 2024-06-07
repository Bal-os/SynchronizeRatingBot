package balashov.os.synchronizeratingbot.core.eventposts.services;

import balashov.os.synchronizeratingbot.core.eventposts.ports.entities.DigestPostContent;
import balashov.os.synchronizeratingbot.core.eventposts.ports.usecases.CreateDigest;
import balashov.os.synchronizeratingbot.core.events.events.ports.entities.EventDto;
import balashov.os.synchronizeratingbot.core.events.events.ports.usecases.GetEventsByDate;
import balashov.os.synchronizeratingbot.core.events.events.ports.usecases.GetEventsByDateRange;
import balashov.os.synchronizeratingbot.core.studparties.DigestTextBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreateDigestService implements CreateDigest {
    private final DigestTextBuilder digestTextBuilder;
    private final GetEventsByDateRange getEventsByDateRange;
    private final GetEventsByDate getEventsByDate;

    @Override
    public DigestPostContent createDigestPost(List<LocalDate> dates) {
        if (dates.size() == 1) return createOneDateDigest(dates.getFirst());
        if (isConsecutiveDates(dates)) return createDigestPost(dates.getFirst(), dates.getLast());

        digestTextBuilder.addTitle(dates.getFirst(), dates.getLast());
        var events = dates.stream()
                .map(date -> Map.of(date, getEventsByDate.getEventsByDate(date)))
                .peek(map -> map.forEach(this::addDateEvents))
                .map(Map::values)
                .flatMap(Collection::stream)
                .flatMap(List::stream)
                .toList();

        return buildDigestContent(events);
    }

    @Override
    public DigestPostContent createDigestPost(LocalDate firstDate, LocalDate lastDate) {
        if (firstDate.isEqual(lastDate)) return createOneDateDigest(lastDate);

        digestTextBuilder.addTitle(firstDate, lastDate);
        List<EventDto> events = getEventsByDateRange.getEventsByDateRange(firstDate, lastDate);
        events.stream()
                .collect(Collectors.groupingBy(EventDto::date))
                .forEach(this::addDateEvents);

        return buildDigestContent(events);
    }

    private DigestPostContent createOneDateDigest(LocalDate date) {
        List<EventDto> events = getEventsByDate.getEventsByDate(date);
        digestTextBuilder.addTitle(date);
        addDateEvents(date, events);
        return buildDigestContent(events);
    }

    private boolean isConsecutiveDates(List<LocalDate> dates) {
        return dates.getLast().minusDays(dates.size()).isEqual(dates.getFirst());
    }

    private void addDateEvents(LocalDate date, List<EventDto> eventList) {
        digestTextBuilder.addEventDay(date);
        eventList.forEach(digestTextBuilder::addEvent);
    }

    private DigestPostContent buildDigestContent(List<EventDto> events) {
        var text = digestTextBuilder.getDigestText();
        return DigestPostContent.builder()
                .text(text)
                .events(events)
                .build();
    }
}

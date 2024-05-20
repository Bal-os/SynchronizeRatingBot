package balashov.os.synchronizeratingbot.core.events.ports.entities;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Builder
public class Event {
    private final String name;
    private final long id;
    private long locationId;
    private List<Long> organizersId;
    private LocalDate date;
    private LocalTime time;
    private String description;
}

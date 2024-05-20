package balashov.os.synchronizeratingbot.core.events.ports.entities;

import lombok.Builder;

import java.util.List;

@Builder
public class Organizer {
    private long id;
    private String name;
    private String instagramLink;
    private long chatId;
    private List<Long> eventsId;
}

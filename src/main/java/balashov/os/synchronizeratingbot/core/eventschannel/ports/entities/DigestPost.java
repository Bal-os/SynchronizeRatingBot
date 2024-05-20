package balashov.os.synchronizeratingbot.core.eventschannel.ports.entities;

import lombok.Builder;

import java.util.List;

@Builder
public record DigestPost(long id, List<Long> eventsId) implements Post {
}

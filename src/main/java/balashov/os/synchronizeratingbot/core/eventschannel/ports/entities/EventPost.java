package balashov.os.synchronizeratingbot.core.eventschannel.ports.entities;

import lombok.Builder;

@Builder
public record EventPost(long eventId, long ratingId) implements Post {
}

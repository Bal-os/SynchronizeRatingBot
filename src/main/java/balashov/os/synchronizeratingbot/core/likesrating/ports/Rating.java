package balashov.os.synchronizeratingbot.core.likesrating.ports;

import lombok.Builder;

@Builder
public class Rating {
    private final long id;
    private Double rating;
    private long likes;
    private long dislikes;
}

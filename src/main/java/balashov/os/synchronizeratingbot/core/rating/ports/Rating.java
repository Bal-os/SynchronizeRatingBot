package balashov.os.synchronizeratingbot.core.rating.ports;

import lombok.Builder;
import lombok.Getter;

@Builder(toBuilder = true)
public class Rating {
    private Double rating;
    private long likes;
    private long dislikes;
}

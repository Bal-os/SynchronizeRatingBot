package balashov.os.synchronizeratingbot.core.posts.ports.entities;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.ChatDto;
import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.MessageDto;
import balashov.os.synchronizeratingbot.core.rating.ports.Rating;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Objects;

@Builder(toBuilder = true)
public record Post(PostContent content,
                   LocalDateTime publicationTime,
                   Rating rating,
                   ChatDto channel,
                   MessageDto message) {
    public boolean isRating() {
        return Objects.nonNull(rating);
    }

    public boolean isPublished() {
        return Objects.nonNull(publicationTime) && Objects.nonNull(message) &&
                publicationTime().isBefore(LocalDateTime.now());
    }

    public boolean isScheduled() {
        return Objects.nonNull(publicationTime) && publicationTime.isAfter(LocalDateTime.now());
    }

    public boolean isUnscheduled() {
        return Objects.isNull(publicationTime);
    }
}

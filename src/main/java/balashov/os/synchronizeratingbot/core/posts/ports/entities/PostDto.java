package balashov.os.synchronizeratingbot.core.posts.ports.entities;

import balashov.os.synchronizeratingbot.core.common.chat.ports.ChatDto;
import balashov.os.synchronizeratingbot.core.common.message.ports.MessageDto;
import balashov.os.synchronizeratingbot.core.rating.ports.Rating;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.Objects;

@Builder(toBuilder = true)
public record PostDto(PostContent content,
                      LocalDateTime publicationTime,
                      Rating rating,
                      ChatDto channel,
                      MessageDto message) {
    public boolean isRated() {
        return Objects.nonNull(rating);
    }

    public boolean isPublished() {
        return Objects.nonNull(publicationTime) && Objects.nonNull(message);
    }

    public boolean isScheduled() {
        return Objects.nonNull(publicationTime) && Objects.isNull(message);
    }

    public boolean isUnscheduled() {
        return Objects.isNull(publicationTime);
    }
}

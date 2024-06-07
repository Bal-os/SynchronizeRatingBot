package balashov.os.synchronizeratingbot.core.eventposts.ports.entities;

import balashov.os.synchronizeratingbot.core.events.events.ports.entities.EventDto;
import balashov.os.synchronizeratingbot.core.posts.ports.entities.ContentType;
import balashov.os.synchronizeratingbot.core.posts.ports.entities.PostContent;
import lombok.Builder;
import lombok.Singular;

import java.util.List;

import static balashov.os.synchronizeratingbot.core.eventposts.ports.entities.ContentTypes.DIGEST;

@Builder(toBuilder = true)
public record DigestPostContent(@Singular List<EventDto> events, String text) implements PostContent {
    @Override
    public ContentType type() {
        return DIGEST;
    }

    @Override
    public List<EventDto> events() {
        return List.copyOf(events);
    }
}

package balashov.os.synchronizeratingbot.core.eventposts.regularpost.ports;

import balashov.os.synchronizeratingbot.core.events.events.ports.entities.EventDto;
import balashov.os.synchronizeratingbot.core.posts.ports.entities.ContentType;
import balashov.os.synchronizeratingbot.core.posts.ports.entities.PostContent;
import lombok.Builder;

import static balashov.os.synchronizeratingbot.core.eventposts.common.ContentTypes.EVENT_POST;

@Builder(toBuilder = true)
public record EventPostContent(EventDto eventDto) implements PostContent {
    @Override
    public ContentType type() {
        return EVENT_POST;
    }
}

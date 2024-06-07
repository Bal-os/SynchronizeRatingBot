package balashov.os.synchronizeratingbot.core.eventposts.services;

import balashov.os.synchronizeratingbot.core.eventposts.ports.entities.ContentTypes;
import balashov.os.synchronizeratingbot.core.eventposts.ports.entities.DigestPostContent;
import balashov.os.synchronizeratingbot.core.eventposts.ports.entities.EventPostContent;
import balashov.os.synchronizeratingbot.core.eventposts.ports.usecases.AddEventToDigest;
import balashov.os.synchronizeratingbot.core.eventposts.ports.usecases.RemoveEventFromDigest;
import balashov.os.synchronizeratingbot.core.posts.ports.usecases.GetPostText;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventPostServicesFactory {
    @Bean
    public AddEventToDigest addEventToDigest() {
        return new AddEventToDigest() {
        };
    }

    @Bean
    public RemoveEventFromDigest removeEventFromDigest() {
        return new RemoveEventFromDigest() {
        };
    }

    @Bean
    public GetPostText getPostText() {
        return post -> switch (post.type()) {
            case ContentTypes.DIGEST -> ((DigestPostContent) post).text();
            case ContentTypes.EVENT_POST -> ((EventPostContent) post).eventDto().description();
            default -> null;
        };
    }
}

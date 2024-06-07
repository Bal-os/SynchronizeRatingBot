package balashov.os.synchronizeratingbot.core.posts.ports.usecases;

import balashov.os.synchronizeratingbot.core.posts.ports.entities.PostDto;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PublishPost {
    default Optional<PostDto> publishPost(PostDto post) {
        return Optional.of(post.toBuilder().publicationTime(LocalDateTime.now()).build());
    }
}

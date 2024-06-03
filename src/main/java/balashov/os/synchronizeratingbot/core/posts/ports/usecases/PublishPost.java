package balashov.os.synchronizeratingbot.core.posts.ports.usecases;

import balashov.os.synchronizeratingbot.core.posts.ports.entities.Post;

import java.time.LocalDateTime;

public interface PublishPost {
    default Post publishPost(Post post) {
        return post.toBuilder().publicationTime(LocalDateTime.now()).build();
    }
}

package balashov.os.synchronizeratingbot.core.posts.ports.usecases;

import balashov.os.synchronizeratingbot.core.posts.ports.entities.Post;

import java.util.List;

public interface GetScheduledPosts {
    List<Post> getScheduledPosts();
}

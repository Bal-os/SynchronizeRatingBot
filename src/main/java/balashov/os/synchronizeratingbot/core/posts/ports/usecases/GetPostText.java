package balashov.os.synchronizeratingbot.core.posts.ports.usecases;

import balashov.os.synchronizeratingbot.core.posts.ports.entities.Post;

public interface GetPostText {
    String getPostText(Post post);
}

package balashov.os.synchronizeratingbot.core.posts.ports.usecases;

import balashov.os.synchronizeratingbot.core.posts.ports.entities.PostDto;

public interface UpdatePost {
    void updatePost(PostDto post);
}

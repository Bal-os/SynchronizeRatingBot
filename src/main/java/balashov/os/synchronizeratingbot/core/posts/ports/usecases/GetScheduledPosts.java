package balashov.os.synchronizeratingbot.core.posts.ports.usecases;

import balashov.os.synchronizeratingbot.core.posts.ports.entities.PostDto;

import java.util.List;

public interface GetScheduledPosts {
    List<PostDto> getScheduledPosts();
}

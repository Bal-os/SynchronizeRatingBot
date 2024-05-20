package balashov.os.synchronizeratingbot.core.eventschannel.ports.usecases;

import balashov.os.synchronizeratingbot.core.eventschannel.ports.entities.Post;

import java.util.List;

public interface GetScheduledPosts {
    List<Post> getScheduledPosts();
}

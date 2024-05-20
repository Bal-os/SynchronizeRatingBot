package balashov.os.synchronizeratingbot.core.eventschannel.ports.usecases;

import balashov.os.synchronizeratingbot.core.eventschannel.ports.entities.Post;

public interface PublishPost {
    boolean publishPost(Post post);
}

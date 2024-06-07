package balashov.os.synchronizeratingbot.core.posts.ports.usecases;

import balashov.os.synchronizeratingbot.core.posts.ports.entities.PostContent;

public interface GetPostText {
    String getPostText(PostContent post);
}

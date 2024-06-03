package balashov.os.synchronizeratingbot.core.posts.ports.usecases;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.ChatDto;
import balashov.os.synchronizeratingbot.core.posts.ports.entities.Post;
import balashov.os.synchronizeratingbot.core.posts.ports.entities.PostContent;

import java.time.LocalDateTime;

public interface CreatePost {
    void addContents(PostContent content);

    void chooseChannel(ChatDto chanel);

    void addRating(boolean isRating);

    void schedulePost(LocalDateTime publishTime);

    Post createPost();
}

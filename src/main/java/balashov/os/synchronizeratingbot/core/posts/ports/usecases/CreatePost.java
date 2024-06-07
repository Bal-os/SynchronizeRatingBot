package balashov.os.synchronizeratingbot.core.posts.ports.usecases;

import balashov.os.synchronizeratingbot.core.common.chat.ports.ChatDto;
import balashov.os.synchronizeratingbot.core.common.creationstates.ports.CreationStateMachine;
import balashov.os.synchronizeratingbot.core.posts.ports.entities.PostContent;
import balashov.os.synchronizeratingbot.core.posts.ports.entities.PostCreationStates;
import balashov.os.synchronizeratingbot.core.posts.ports.entities.PostDto;

import java.time.LocalDateTime;

public interface CreatePost extends CreationStateMachine<PostDto, PostCreationStates> {
    void addContents(PostContent content);

    void chooseChannel(ChatDto chanel);

    void addRating(boolean isRating);

    void schedulePost(LocalDateTime publishTime);
}

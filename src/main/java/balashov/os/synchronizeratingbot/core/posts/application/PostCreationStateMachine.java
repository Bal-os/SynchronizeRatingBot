package balashov.os.synchronizeratingbot.core.posts.application;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.ChatDto;
import balashov.os.synchronizeratingbot.core.creationstates.AbstractCreateStateMachine;
import balashov.os.synchronizeratingbot.core.creationstates.CreationStates;
import balashov.os.synchronizeratingbot.core.posts.ports.entities.Post;
import balashov.os.synchronizeratingbot.core.posts.ports.entities.PostContent;
import balashov.os.synchronizeratingbot.core.posts.ports.entities.PostCreationStates;
import balashov.os.synchronizeratingbot.core.posts.ports.usecases.CreatePost;
import balashov.os.synchronizeratingbot.core.posts.ports.usecases.CreatePostScheduler;
import balashov.os.synchronizeratingbot.core.posts.ports.usecases.PublishPost;
import balashov.os.synchronizeratingbot.core.rating.ports.Rating;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component("createPostService")
@RequiredArgsConstructor
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PostCreationStateMachine extends AbstractCreateStateMachine<PostCreationStates> implements CreatePost {
    private final CreatePostScheduler scheduler;
    private final PublishPost publisher;
    private Post.PostBuilder builder;

    @Override
    @PostConstruct
    public void restart() {
        builder = Post.builder();
        Arrays.stream(PostCreationStates.values())
                .filter(CreationStates::isInitial)
                .findFirst()
                .ifPresent(this::setCurrentState);
    }

    @Override
    public void addContents(PostContent content) {
        builder.content(content);
        transitionToNextState();
    }

    @Override
    public void chooseChannel(ChatDto chanel) {
        builder.channel(chanel);
        transitionToNextState();
    }

    @Override
    public void addRating(boolean isRating) {
        if (isRating) {
            var rating = Rating.builder()
                            .likes(0)
                            .dislikes(0)
                            .build();
            builder.rating(rating);
        }
        transitionToNextState();
    }

    @Override
    public void schedulePost(LocalDateTime publishTime) {
        builder.publicationTime(publishTime);
        transitionToNextState();
    }

    @Override
    public Post createPost() {
        var post = builder.build();
        if (post.publicationTime().isAfter(LocalDateTime.now())) {
            scheduler.schedulePost(post);
            return post;
        }
        return publisher.publishPost(post);
    }
}

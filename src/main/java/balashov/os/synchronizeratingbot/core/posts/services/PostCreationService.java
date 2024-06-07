package balashov.os.synchronizeratingbot.core.posts.services;

import balashov.os.synchronizeratingbot.core.common.chat.ports.ChatDto;
import balashov.os.synchronizeratingbot.core.common.creationstates.ports.AbstractCreationStateMachine;
import balashov.os.synchronizeratingbot.core.posts.ports.entities.PostContent;
import balashov.os.synchronizeratingbot.core.posts.ports.entities.PostCreationStates;
import balashov.os.synchronizeratingbot.core.posts.ports.entities.PostDto;
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
import java.util.Optional;

@Component("createPostService")
@RequiredArgsConstructor
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PostCreationService extends AbstractCreationStateMachine<PostDto, PostCreationStates> implements CreatePost {
    private final CreatePostScheduler scheduler;
    private final PublishPost publisher;
    private PostDto.PostDtoBuilder builder;

    @Override
    @PostConstruct
    public void restart() {
        builder = PostDto.builder();
        super.restart();
    }

    @Override
    public Optional<PostDto> create() {
        if (!getCurrentState().isFinal())
            return Optional.empty();

        var post = builder.build();
        if (post.publicationTime().isAfter(LocalDateTime.now())) {
            scheduler.schedulePost(post);
            return Optional.of(post);
        }
        return publisher.publishPost(post);
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
}

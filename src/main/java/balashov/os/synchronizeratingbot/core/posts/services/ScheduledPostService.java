package balashov.os.synchronizeratingbot.core.posts.services;

import balashov.os.synchronizeratingbot.core.posts.ports.entities.PostDto;
import balashov.os.synchronizeratingbot.core.posts.ports.usecases.GetScheduledPosts;
import balashov.os.synchronizeratingbot.core.posts.ports.usecases.PublishPost;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduledPostService {
    private final GetScheduledPosts getScheduledPosts;
    private final PublishPost publishPost;

    @Scheduled(fixedRateString = "${post.scheduled.check.rate}")
    public void checkAndPublishScheduledPosts() {
        List<PostDto> scheduledPosts = getScheduledPosts.getScheduledPosts();

        scheduledPosts.stream()
                .filter(PostDto::isScheduled)
                .filter(this::checkIsTimeToPublish)
                .forEach(publishPost::publishPost);
    }

    private boolean checkIsTimeToPublish(PostDto post) {
        return !post.publicationTime().isAfter(LocalDateTime.now());
    }
}

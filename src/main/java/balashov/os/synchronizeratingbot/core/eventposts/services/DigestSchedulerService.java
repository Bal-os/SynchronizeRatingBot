package balashov.os.synchronizeratingbot.core.eventposts.services;

import balashov.os.synchronizeratingbot.core.eventposts.ports.entities.DigestPostContent;
import balashov.os.synchronizeratingbot.core.eventposts.ports.usecases.CreateDigest;
import balashov.os.synchronizeratingbot.core.posts.ports.entities.PostDto;
import balashov.os.synchronizeratingbot.core.posts.ports.usecases.PublishPost;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DigestSchedulerService {
    private final CreateDigest createDigest;
    private final PublishPost publishPost;

    @Scheduled(cron = "${digest.scheduler.cron}")
    public void scheduleDigestPost() {
        List<LocalDate> dates = calculateThisWeekEndDates();
        DigestPostContent digestPostContent = createDigest.createDigestPost(dates);

        PostDto post = PostDto.builder()
                .content(digestPostContent)
                .build();

        publishPost.publishPost(post);
    }

    private List<LocalDate> calculateThisWeekEndDates() {
        LocalDate now = LocalDate.now();
        LocalDate start = now.with(TemporalAdjusters.previousOrSame(DayOfWeek.THURSDAY));
        LocalDate end = now.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        return start.datesUntil(end.plusDays(1)).collect(Collectors.toList());
    }

}

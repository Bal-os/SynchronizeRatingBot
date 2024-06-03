package balashov.os.synchronizeratingbot.core.eventposts.digest.ports.usecases;

import balashov.os.synchronizeratingbot.core.eventposts.digest.ports.entities.DigestPostContent;

import java.time.LocalDate;
import java.util.List;

public interface CreateDigestContent {
    DigestPostContent createDigestPost(List<LocalDate> dates);
}

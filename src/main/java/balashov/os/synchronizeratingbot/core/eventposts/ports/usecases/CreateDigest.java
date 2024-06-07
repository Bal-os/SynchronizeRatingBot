package balashov.os.synchronizeratingbot.core.eventposts.ports.usecases;

import balashov.os.synchronizeratingbot.core.eventposts.ports.entities.DigestPostContent;

import java.time.LocalDate;
import java.util.List;

public interface CreateDigest {
    DigestPostContent createDigestPost(List<LocalDate> dates);

    DigestPostContent createDigestPost(LocalDate firstDate, LocalDate lastDate);
}

package balashov.os.synchronizeratingbot.core.eventschannel.ports.usecases;

import balashov.os.synchronizeratingbot.core.eventschannel.ports.entities.DigestPost;

import java.time.LocalDate;
import java.util.List;

public interface CreateDigestPost {
    DigestPost createDigestPost(List<LocalDate> dates);
}

package balashov.os.synchronizeratingbot.core.eventschannel.ports.usecases;

import balashov.os.synchronizeratingbot.core.eventschannel.ports.entities.EventPost;

public interface CreateEventPost {
    EventPost createEventPost(long eventId);
}

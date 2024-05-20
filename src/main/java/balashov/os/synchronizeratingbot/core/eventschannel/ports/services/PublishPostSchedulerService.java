package balashov.os.synchronizeratingbot.core.eventschannel.ports.services;

import balashov.os.synchronizeratingbot.core.eventschannel.ports.entities.Post;

public interface PublishPostSchedulerService {
    void createPublishPostScheduler(Post post);
    void cancelPublishPostScheduler(Post post);
}

package balashov.os.synchronizeratingbot.core.eventposts.digest.application;

import balashov.os.synchronizeratingbot.core.eventposts.digest.ports.usecases.AddEventToDigest;
import balashov.os.synchronizeratingbot.core.eventposts.digest.ports.usecases.RemoveEventFromDigest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DigestServicesFactory {
    @Bean
    public AddEventToDigest addEventToDigest() {
        return new AddEventToDigest() {
        };
    }

    @Bean
    public RemoveEventFromDigest removeEventFromDigest() {
        return new RemoveEventFromDigest() {
        };
    }
}

package balashov.os.synchronizeratingbot.infrastructure.telegram.events;

import balashov.os.synchronizeratingbot.core.events.organizers.ports.entities.OrganizerDto;
import balashov.os.synchronizeratingbot.core.events.organizers.ports.usecases.GetActualLink;
import org.springframework.stereotype.Service;

@Service
public class GetActualLinkService implements GetActualLink {
    @Override
    public String getActualLink(OrganizerDto organizer) {
        var organizerChat = organizer.channel() != null ? organizer.channel() : organizer.chat();
        return organizerChat != null ? "tg://chat?id=" + organizerChat.id() : organizer.instagramLink();
    }
}

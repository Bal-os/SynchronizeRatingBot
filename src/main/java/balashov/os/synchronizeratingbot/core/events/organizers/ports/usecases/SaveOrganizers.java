package balashov.os.synchronizeratingbot.core.events.organizers.ports.usecases;

import balashov.os.synchronizeratingbot.core.events.organizers.ports.entities.OrganizerDto;

import java.util.List;

public interface SaveOrganizers {
    void saveOrganizers(List<OrganizerDto> organizers);
}

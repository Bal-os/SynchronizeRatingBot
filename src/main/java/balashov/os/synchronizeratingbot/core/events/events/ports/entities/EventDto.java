package balashov.os.synchronizeratingbot.core.events.events.ports.entities;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.PhotoDto;
import balashov.os.synchronizeratingbot.core.events.locations.ports.entities.LocationDto;
import balashov.os.synchronizeratingbot.core.events.organizers.ports.entities.OrganizerDto;
import lombok.Builder;
import lombok.Singular;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Builder(toBuilder = true)
public record EventDto(String name,
                       String link,
                       @Singular List<OrganizerDto> organizers,
                       PhotoDto photo,
                       LocationDto location,
                       String ticketLink,
                       LocalDate date,
                       LocalTime time,
                       String description,
                       Boolean isFree,
                       Boolean isCharity) {
}

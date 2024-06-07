package balashov.os.synchronizeratingbot.core.events.events.ports.usecases;

import balashov.os.synchronizeratingbot.core.common.creationstates.ports.CreationStateMachine;
import balashov.os.synchronizeratingbot.core.common.photo.ports.PhotoDto;
import balashov.os.synchronizeratingbot.core.events.events.ports.entities.EventCreationStates;
import balashov.os.synchronizeratingbot.core.events.events.ports.entities.EventDto;
import balashov.os.synchronizeratingbot.core.events.locations.ports.entities.LocationDto;
import balashov.os.synchronizeratingbot.core.events.organizers.ports.entities.OrganizerDto;

import java.time.LocalDate;
import java.time.LocalTime;

public interface CreateEvent extends CreationStateMachine<EventDto, EventCreationStates> {
    void addTitle(String title);

    void addLink(String link);

    void addEventDate(LocalDate date);

    void addEventTime(LocalTime time);

    void addOrganizer(OrganizerDto organizer);

    void addTicketLink(String ticketLink);

    void addPhoto(PhotoDto photo);

    void addLocation(LocationDto location);

    void addIsFree(Boolean isFree);

    void addIsCharity(Boolean isCharity);

    void addAdditionalInfo(String info);
}

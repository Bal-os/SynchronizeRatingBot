package balashov.os.synchronizeratingbot.core.events.events.ports.usecases;

import balashov.os.synchronizeratingbot.core.events.locations.ports.entities.LocationDto;
import balashov.os.synchronizeratingbot.core.events.organizers.ports.entities.OrganizerDto;

import java.time.LocalDate;
import java.time.LocalTime;

public interface CreateEventDescription {
    void clear();

    void addTitle(String title);

    void addLink(String link);

    void addEventDate(LocalDate date);

    void addEventTime(LocalTime time);

    void addOrganizer(OrganizerDto organizer);

    void addTicketLink(String ticketLink);

    void addLocation(LocationDto location);

    void addIsFree(Boolean isFree);

    void addIsCharity(Boolean isCharity);

    void addAdditionalInfo(String info);

    String getDescription();
}

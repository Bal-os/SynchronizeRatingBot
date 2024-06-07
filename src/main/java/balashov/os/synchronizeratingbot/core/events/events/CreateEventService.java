package balashov.os.synchronizeratingbot.core.events.events;

import balashov.os.synchronizeratingbot.core.common.creationstates.ports.AbstractCreationStateMachine;
import balashov.os.synchronizeratingbot.core.common.photo.ports.PhotoDto;
import balashov.os.synchronizeratingbot.core.events.events.ports.entities.EventCreationStates;
import balashov.os.synchronizeratingbot.core.events.events.ports.entities.EventDto;
import balashov.os.synchronizeratingbot.core.events.events.ports.usecases.CreateEvent;
import balashov.os.synchronizeratingbot.core.events.events.ports.usecases.CreateEventDescription;
import balashov.os.synchronizeratingbot.core.events.locations.ports.entities.LocationDto;
import balashov.os.synchronizeratingbot.core.events.organizers.ports.entities.OrganizerDto;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class CreateEventService extends AbstractCreationStateMachine<EventDto, EventCreationStates> implements CreateEvent {
    private final CreateEventDescription createDescription;
    private EventDto.EventDtoBuilder eventBuilder;

    @PostConstruct
    public void restart() {
        eventBuilder = EventDto.builder();
        createDescription.clear();
        super.restart();
    }

    public void addTitle(String title) {
        eventBuilder.title(title);
        createDescription.addTitle(title);
        transitionToNextState();
    }

    public void addLink(String link) {
        eventBuilder.link(link);
        createDescription.addLink(link);
        transitionToNextState();
    }

    public void addOrganizer(OrganizerDto organizer) {
        eventBuilder.organizer(organizer);
        createDescription.addOrganizer(organizer);
    }

    public void addEventDate(LocalDate date) {
        eventBuilder.date(date);
        createDescription.addEventDate(date);
        transitionToNextState();
    }

    public void addEventTime(LocalTime time) {
        eventBuilder.time(time);
        createDescription.addEventTime(time);
        transitionToNextState();
    }

    public void addLocation(LocationDto location) {
        eventBuilder.location(location);
        createDescription.addLocation(location);
        transitionToNextState();
    }

    public void addIsFree(Boolean isFree) {
        eventBuilder.isFree(isFree);
        createDescription.addIsFree(isFree);
        transitionToNextState();
    }

    public void addIsCharity(Boolean isCharity) {
        eventBuilder.isCharity(isCharity);
        createDescription.addIsCharity(isCharity);
        transitionToNextState();
    }

    public void addTicketLink(String ticketLink) {
        eventBuilder.ticketLink(ticketLink);
        createDescription.addTicketLink(ticketLink);
        transitionToNextState();
    }

    public void addPhoto(PhotoDto photo) {
        eventBuilder.photo(photo);
        transitionToNextState();
    }

    @Override
    public void addAdditionalInfo(String info) {
        createDescription.addAdditionalInfo(info);
        eventBuilder.additionalInfo(info);
        transitionToNextState();
    }

    @Override
    public Optional<EventDto> create() {
        eventBuilder.description(createDescription.getDescription());
        return Optional.of(eventBuilder.build());
    }
}
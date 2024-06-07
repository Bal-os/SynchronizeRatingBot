package balashov.os.synchronizeratingbot.core.events.locations;

import balashov.os.synchronizeratingbot.core.common.creationstates.ports.AbstractCreationStateMachine;
import balashov.os.synchronizeratingbot.core.events.locations.ports.entities.LocationCreationStates;
import balashov.os.synchronizeratingbot.core.events.locations.ports.entities.LocationDto;
import balashov.os.synchronizeratingbot.core.events.locations.ports.usecases.CreateLocation;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CreateLocationService extends AbstractCreationStateMachine<LocationDto, LocationCreationStates> implements CreateLocation {
    private LocationDto.LocationDtoBuilder locationBuilder;

    @PostConstruct
    public void restart() {
        locationBuilder = LocationDto.builder();
        super.restart();
    }

    @Override
    public void addName(String name) {
        locationBuilder.name(name);
        transitionToNextState();
    }

    @Override
    public void addGoogleMapsLink(String link) {
        locationBuilder.googleMapsLink(link);
        transitionToNextState();
    }

    @Override
    public void addType(String type) {
        locationBuilder.type(type);
        transitionToNextState();
    }

    @Override
    public void addAddress(String address) {
        locationBuilder.address(address);
        transitionToNextState();
    }

    @Override
    public void addInstagramLink(String link) {
        locationBuilder.instagramLink(link);
        transitionToNextState();
    }

    @Override
    public void addTelegramLink(String link) {
        locationBuilder.telegramLink(link);
        transitionToNextState();
    }

    @Override
    public void addNumber(String number) {
        locationBuilder.number(number);
        transitionToNextState();
    }

    @Override
    public Optional<LocationDto> create() {
        return Optional.of(locationBuilder.build());
    }
}
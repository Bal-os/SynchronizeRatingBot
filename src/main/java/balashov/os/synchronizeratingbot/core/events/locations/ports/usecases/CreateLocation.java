package balashov.os.synchronizeratingbot.core.events.locations.ports.usecases;

import balashov.os.synchronizeratingbot.core.common.creationstates.ports.CreationStateMachine;
import balashov.os.synchronizeratingbot.core.events.locations.ports.entities.LocationCreationStates;
import balashov.os.synchronizeratingbot.core.events.locations.ports.entities.LocationDto;

public interface CreateLocation extends CreationStateMachine<LocationDto, LocationCreationStates> {
    void addName(String name);

    void addGoogleMapsLink(String link);

    void addType(String type);

    void addAddress(String address);

    void addInstagramLink(String link);

    void addTelegramLink(String link);

    void addNumber(String number);
}
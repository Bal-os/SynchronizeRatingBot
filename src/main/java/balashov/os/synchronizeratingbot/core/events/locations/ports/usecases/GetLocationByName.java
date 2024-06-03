package balashov.os.synchronizeratingbot.core.events.locations.ports.usecases;

import balashov.os.synchronizeratingbot.core.events.locations.ports.entities.LocationDto;

import java.util.List;

public interface GetLocationByName {
    List<LocationDto> getLocationByName(String name);
}

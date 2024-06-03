package balashov.os.synchronizeratingbot.core.events.locations.ports.usecases;

import balashov.os.synchronizeratingbot.core.events.locations.ports.entities.LocationDto;

import java.util.List;

public interface GetLocationByAddress {
    List<LocationDto> getLocationByAddress(String address);
}

package balashov.os.synchronizeratingbot.core.events.ports.services;

import balashov.os.synchronizeratingbot.core.events.ports.entities.Location;

import java.util.List;

public interface GetLocationsService {
    List<Location> getLocationByAddress(String address);
    List<Location> getLocationByName(String name);
}

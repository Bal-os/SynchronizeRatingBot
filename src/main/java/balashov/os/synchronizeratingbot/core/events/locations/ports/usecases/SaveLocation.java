package balashov.os.synchronizeratingbot.core.events.locations.ports.usecases;

import balashov.os.synchronizeratingbot.core.events.locations.ports.entities.LocationDto;

public interface SaveLocation {
    LocationDto saveLocation(LocationDto locationDto);
}

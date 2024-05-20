package balashov.os.synchronizeratingbot.core.events.ports.usecases;

import balashov.os.synchronizeratingbot.core.events.ports.entities.Location;

public interface GetLocation {
    Location getLocation(long locationId);
}

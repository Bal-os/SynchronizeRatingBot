package balashov.os.synchronizeratingbot.core.events.locations.ports.entities;

import lombok.Builder;

@Builder(toBuilder = true)
public record LocationDto(String name,
                          String address,
                          String googleMapsLink,
                          String instagramLink,
                          String telegramLink,
                          String number,
                          String type) {
}

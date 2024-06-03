package balashov.os.synchronizeratingbot.core.events.locations.ports.entities;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LocationDto {
    private long id;
    private String name;
    private String address;
    private String googleMapsLink;
    private String instagramLink;
    private String telegramLink;
    private String number;
    private String type;
}

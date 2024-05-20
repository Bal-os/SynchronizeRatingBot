package balashov.os.synchronizeratingbot.core.events.ports.entities;

import lombok.Builder;

@Builder
public class Location {
    private long id;
    private String name;
    private String address;
    private String googleMapsLink;
    private String instagramLink;
    private String telegramLink;
    private String number;
    private String type;
}

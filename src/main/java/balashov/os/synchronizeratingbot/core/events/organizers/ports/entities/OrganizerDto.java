package balashov.os.synchronizeratingbot.core.events.organizers.ports.entities;

import balashov.os.synchronizeratingbot.core.common.chat.ports.ChatDto;
import balashov.os.synchronizeratingbot.core.common.user.ports.UserDto;
import balashov.os.synchronizeratingbot.core.events.events.ports.entities.EventDto;
import lombok.Builder;
import lombok.Singular;

import java.util.List;

@Builder(toBuilder = true)
public record OrganizerDto(String name,
                           String instagramLink,
                           ChatDto chat,
                           ChatDto channel,
                           @Singular List<EventDto> events,
                           @Singular List<UserDto> members) {
}
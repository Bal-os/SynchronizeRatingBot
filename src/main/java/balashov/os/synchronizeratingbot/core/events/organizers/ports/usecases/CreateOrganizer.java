package balashov.os.synchronizeratingbot.core.events.organizers.ports.usecases;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.ChatDto;
import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.UserDto;
import balashov.os.synchronizeratingbot.core.events.organizers.ports.entities.OrganizerDto;

public interface CreateOrganizer {
    void addName(String name);

    void addInstagramLink(String instagramLink);

    void addChat(ChatDto chat);

    void addChannel(ChatDto channel);

    void addMember(UserDto member);

    OrganizerDto createOrganizer();
}

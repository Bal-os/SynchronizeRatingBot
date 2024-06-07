package balashov.os.synchronizeratingbot.core.events.organizers.ports.usecases;

import balashov.os.synchronizeratingbot.core.common.chat.ports.ChatDto;
import balashov.os.synchronizeratingbot.core.common.creationstates.ports.CreationStateMachine;
import balashov.os.synchronizeratingbot.core.common.user.ports.UserDto;
import balashov.os.synchronizeratingbot.core.events.organizers.ports.entities.OrganizerCreationStates;
import balashov.os.synchronizeratingbot.core.events.organizers.ports.entities.OrganizerDto;

public interface CreateOrganizer extends CreationStateMachine<OrganizerDto, OrganizerCreationStates> {
    void addName(String name);

    void addInstagramLink(String instagramLink);

    void addChat(ChatDto chat);

    void addChannel(ChatDto channel);

    void addMember(UserDto member);
}

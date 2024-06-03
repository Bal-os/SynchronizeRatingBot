package balashov.os.synchronizeratingbot.core.events.organizers.application;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.ChatDto;
import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.UserDto;
import balashov.os.synchronizeratingbot.core.events.organizers.ports.entities.OrganizerDto;
import balashov.os.synchronizeratingbot.core.events.organizers.ports.usecases.CreateOrganizer;
import balashov.os.synchronizeratingbot.core.events.organizers.ports.entities.OrganizerCreationStates;
import balashov.os.synchronizeratingbot.core.creationstates.AbstractCreateStateMachine;
import balashov.os.synchronizeratingbot.core.creationstates.CreationStates;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CreateOrganizerService extends AbstractCreateStateMachine<OrganizerCreationStates> implements CreateOrganizer {
    private OrganizerDto.OrganizerDtoBuilder organizerBuilder;

    @PostConstruct
    public void restart() {
        organizerBuilder = OrganizerDto.builder();
        Arrays.stream(OrganizerCreationStates.values())
                .filter(CreationStates::isInitial)
                .findFirst()
                .stream()
                .findFirst()
                .ifPresent(this::setCurrentState);

    }

    public void addName(String name) {
        organizerBuilder.name(name);
        transitionToNextState();
    }

    public void addInstagramLink(String instagramLink) {
        organizerBuilder.instagramLink(instagramLink);
        transitionToNextState();
    }

    public void addChat(ChatDto chat) {
        organizerBuilder.chat(chat);
        transitionToNextState();
    }

    public void addChannel(ChatDto channel) {
        organizerBuilder.channel(channel);
        transitionToNextState();
    }

    public void addMember(UserDto member) {
        organizerBuilder.member(member);
    }

    public OrganizerDto createOrganizer() {
        var organizer = organizerBuilder.build();
        this.restart();
        return organizer;
    }
}

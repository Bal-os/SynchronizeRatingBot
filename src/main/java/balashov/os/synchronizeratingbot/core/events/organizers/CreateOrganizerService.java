package balashov.os.synchronizeratingbot.core.events.organizers;

import balashov.os.synchronizeratingbot.core.common.chat.ports.ChatDto;
import balashov.os.synchronizeratingbot.core.common.creationstates.ports.AbstractCreationStateMachine;
import balashov.os.synchronizeratingbot.core.common.user.ports.UserDto;
import balashov.os.synchronizeratingbot.core.events.organizers.ports.entities.OrganizerCreationStates;
import balashov.os.synchronizeratingbot.core.events.organizers.ports.entities.OrganizerDto;
import balashov.os.synchronizeratingbot.core.events.organizers.ports.usecases.CreateOrganizer;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CreateOrganizerService extends AbstractCreationStateMachine<OrganizerDto, OrganizerCreationStates> implements CreateOrganizer {
    private OrganizerDto.OrganizerDtoBuilder organizerBuilder;

    @PostConstruct
    public void restart() {
        organizerBuilder = OrganizerDto.builder();
        super.restart();
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

    public Optional<OrganizerDto> create() {
        return Optional.of(organizerBuilder.build());
    }
}

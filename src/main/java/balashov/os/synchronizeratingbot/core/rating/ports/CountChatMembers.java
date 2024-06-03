package balashov.os.synchronizeratingbot.core.rating.ports;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.ChatDto;

import java.util.Optional;

public interface CountChatMembers {
    Optional<Integer> countMembers(ChatDto chatDto);
}

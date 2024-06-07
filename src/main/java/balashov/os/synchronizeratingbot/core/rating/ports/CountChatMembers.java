package balashov.os.synchronizeratingbot.core.rating.ports;

import balashov.os.synchronizeratingbot.core.common.chat.ports.ChatDto;

import java.util.Optional;

public interface CountChatMembers {
    Optional<Integer> countMembers(ChatDto chatDto);
}

package balashov.os.synchronizeratingbot.core.channel.common.ports.usecases;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.ChatDto;

import java.util.Optional;

public interface GetChatById {
    Optional<ChatDto> getChat(long chatId);
}

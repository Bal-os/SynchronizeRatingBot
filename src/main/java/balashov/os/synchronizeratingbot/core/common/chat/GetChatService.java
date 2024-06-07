package balashov.os.synchronizeratingbot.core.common.chat;

import balashov.os.synchronizeratingbot.core.common.chat.ports.ChatDto;
import balashov.os.synchronizeratingbot.core.common.chat.ports.GetChatById;
import balashov.os.synchronizeratingbot.core.common.chat.ports.SaveChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetChatService implements GetChatById {
    private final GetChatById getSavedChatById;
    private final GetChatById getChatByIdProvider;
    private final SaveChatRepository saveChat;

    @Override
    public Optional<ChatDto> getChat(long chatId) {
        var savedChat = getSavedChatById.getChat(chatId);
        var chat = getChatByIdProvider.getChat(chatId);

        if (savedChat.isEmpty() || !chat.map(savedChat.get()::equals).orElse(false)) {
            chat.ifPresent(saveChat::saveChat);
        }
        return chat;
    }
}

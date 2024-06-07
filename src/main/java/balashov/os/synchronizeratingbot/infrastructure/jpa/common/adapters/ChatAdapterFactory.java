package balashov.os.synchronizeratingbot.infrastructure.jpa.common.adapters;

import balashov.os.synchronizeratingbot.core.common.chat.ports.GetChatById;
import balashov.os.synchronizeratingbot.core.common.chat.ports.SaveChatRepository;
import balashov.os.synchronizeratingbot.infrastructure.jpa.common.mappers.ChatMapper;
import balashov.os.synchronizeratingbot.infrastructure.jpa.common.repositories.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class ChatAdapterFactory {
    ChatRepository repository;
    ChatMapper mapper;

    @Bean
    public SaveChatRepository saveChatRepository() {
        return chat -> repository.save(mapper.mapToEntity(chat));
    }

    @Bean
    public GetChatById getSavedChatById() {
        return chatId -> repository.findById(chatId)
                .map(mapper::mapToDto);
    }
}

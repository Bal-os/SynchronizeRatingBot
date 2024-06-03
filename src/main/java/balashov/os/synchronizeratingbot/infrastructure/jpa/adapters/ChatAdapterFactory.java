package balashov.os.synchronizeratingbot.infrastructure.jpa.adapters;

import balashov.os.synchronizeratingbot.core.channel.common.ports.repository.SaveChatRepository;
import balashov.os.synchronizeratingbot.core.channel.common.ports.usecases.GetChatById;
import balashov.os.synchronizeratingbot.infrastructure.jpa.mappers.ChatMapper;
import balashov.os.synchronizeratingbot.infrastructure.jpa.repositories.ChatRepository;
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

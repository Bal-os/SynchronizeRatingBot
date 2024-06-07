package balashov.os.synchronizeratingbot.infrastructure.jpa.common.adapters;

import balashov.os.synchronizeratingbot.core.common.message.ports.GetMessageById;
import balashov.os.synchronizeratingbot.core.common.message.ports.SaveMessageRepository;
import balashov.os.synchronizeratingbot.infrastructure.jpa.common.mappers.MessageIdMapper;
import balashov.os.synchronizeratingbot.infrastructure.jpa.common.mappers.MessageMapper;
import balashov.os.synchronizeratingbot.infrastructure.jpa.common.repositories.MessageRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageAdaptersFactory {
    MessageRepository repository;
    MessageIdMapper idMapper;
    MessageMapper mapper;

    @Bean
    public SaveMessageRepository saveMessageRepository() {
        return message -> repository.save(mapper.mapToEntity(message));
    }

    @Bean
    public GetMessageById getSavedMessageById() {
        return messageId -> repository.findById(idMapper.mapToMessageKey(messageId))
                .map(mapper::mapToDto);
    }
}

package balashov.os.synchronizeratingbot.infrastructure.jpa.adapters;

import balashov.os.synchronizeratingbot.core.channel.common.ports.repository.SaveMessageRepository;
import balashov.os.synchronizeratingbot.core.channel.common.ports.usecases.GetMessageById;
import balashov.os.synchronizeratingbot.infrastructure.jpa.mappers.MessageIdMapper;
import balashov.os.synchronizeratingbot.infrastructure.jpa.mappers.MessageMapper;
import balashov.os.synchronizeratingbot.infrastructure.jpa.repositories.MessageRepository;
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

package balashov.os.synchronizeratingbot.infrastructure.telegram.adapters.channel.mappers;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.ChatDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.telegram.telegrambots.meta.api.objects.Chat;

@Mapper(componentModel = "spring")
public interface TelegramChatMapper {
    @Mapping(source = "chat.id", target = "id")
    @Mapping(source = "chat.title", target = "title")
    ChatDto toDto(Chat chat);
}

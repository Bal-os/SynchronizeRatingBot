package balashov.os.synchronizeratingbot.infrastructure.telegram.common.adapters.mappers;

import balashov.os.synchronizeratingbot.core.common.chat.ports.ChatDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.telegram.telegrambots.meta.api.objects.Chat;

@Mapper(componentModel = "spring")
public interface TelegramChatMapper {
    @Mapping(source = "chat.id", target = "id")
    @Mapping(source = "chat.title", target = "title")
    ChatDto toDto(Chat chat);
}

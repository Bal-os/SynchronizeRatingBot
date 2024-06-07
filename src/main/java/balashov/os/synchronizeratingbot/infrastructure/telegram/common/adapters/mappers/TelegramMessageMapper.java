package balashov.os.synchronizeratingbot.infrastructure.telegram.common.adapters.mappers;

import balashov.os.synchronizeratingbot.core.common.message.ports.MessageDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.telegram.telegrambots.meta.api.objects.message.Message;

@Mapper(componentModel = "spring", uses = {TelegramUserMapper.class, TelegramChatMapper.class})
public interface TelegramMessageMapper {
    @Mapping(source = "message.from", target = "sender")
    @Mapping(source = "message.chat", target = "chat")
    MessageDto toDto(Message message);
}

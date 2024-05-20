package balashov.os.synchronizeratingbot.infrastructure.mapstruct;

import balashov.os.synchronizeratingbot.infrastructure.sql.entities.ChatUserEntity;
import balashov.os.synchronizeratingbot.infrastructure.telegram.entities.TelegramChatMemberDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ChatMemberMapper {
    @Mapping(target = "user", source = "user")
    @Mapping(target = "chat", source = "chat")
    @Mapping(target = "status", source = "status")
    TelegramChatMemberDto mapToDto(ChatUserEntity chatUserEntity);

    @Mapping(target = "user", source = "user")
    @Mapping(target = "chat", source = "chat")
    @Mapping(target = "status", source = "status")
    ChatUserEntity mapToChatUserEntity(TelegramChatMemberDto chatMemberDto);
}

package balashov.os.synchronizeratingbot.infrastructure.telegram.common.adapters.factories;

import balashov.os.synchronizeratingbot.core.common.chat.ports.GetChatById;
import balashov.os.synchronizeratingbot.core.common.member.ports.GetMember;
import balashov.os.synchronizeratingbot.core.common.photo.ports.GetPhotoById;
import balashov.os.synchronizeratingbot.infrastructure.telegram.common.adapters.mappers.TelegramChatMapper;
import balashov.os.synchronizeratingbot.infrastructure.telegram.common.adapters.mappers.TelegramMemberMapper;
import balashov.os.synchronizeratingbot.infrastructure.telegram.common.adapters.mappers.TelegramPhotoMapper;
import balashov.os.synchronizeratingbot.infrastructure.telegram.common.application.services.TelegramClientProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChat;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChatMember;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class CommonAdaptersFactory {
    private final TelegramClientProxy telegramClient;

    @Bean
    public GetChatById getChatByIdProvider(TelegramChatMapper mapper) {
        return chatId -> Optional.of(GetChat.builder().chatId(String.valueOf(chatId)).build())
                .map(telegramClient::execute)
                .map(mapper::toDto);
    }

    @Bean
    public GetMember getMemberProvider(TelegramMemberMapper mapper) {
        return (chat, user) -> Optional.of(GetChatMember.builder().chatId(chat.id()).userId(user.id()).build())
                .map(telegramClient::execute)
                .map(mapper::toDto);
    }

    @Bean
    public GetPhotoById getPhotoByIdProvider(TelegramPhotoMapper mapper) {
        return photoId -> Optional.ofNullable(GetFile.builder().fileId(photoId).build())
                .map(telegramClient::execute)
                .map(mapper::toDto);
    }
}

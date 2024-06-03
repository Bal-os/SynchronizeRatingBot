package balashov.os.synchronizeratingbot.infrastructure.telegram.adapters.channel.factories;

import balashov.os.synchronizeratingbot.core.channel.common.ports.usecases.GetChatById;
import balashov.os.synchronizeratingbot.core.channel.common.ports.usecases.GetMember;
import balashov.os.synchronizeratingbot.core.channel.common.ports.usecases.GetPhotoById;
import balashov.os.synchronizeratingbot.infrastructure.telegram.adapters.channel.mappers.TelegramChatMapper;
import balashov.os.synchronizeratingbot.infrastructure.telegram.adapters.channel.mappers.TelegramMemberMapper;
import balashov.os.synchronizeratingbot.infrastructure.telegram.adapters.channel.mappers.TelegramPhotoMapper;
import balashov.os.synchronizeratingbot.infrastructure.telegram.executors.TelegramClientProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChat;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChatMember;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class ChannelAdaptersFactory {
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

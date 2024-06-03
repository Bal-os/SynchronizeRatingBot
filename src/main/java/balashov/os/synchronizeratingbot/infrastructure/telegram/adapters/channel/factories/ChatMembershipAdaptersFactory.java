package balashov.os.synchronizeratingbot.infrastructure.telegram.adapters.channel.factories;

import balashov.os.synchronizeratingbot.core.channel.memberstatus.ports.entities.MemberStatuses;
import balashov.os.synchronizeratingbot.core.channel.memberstatus.ports.usecases.CheckAdminRole;
import balashov.os.synchronizeratingbot.core.channel.memberstatus.ports.usecases.CheckChatMembership;
import balashov.os.synchronizeratingbot.core.channel.memberstatus.ports.usecases.GetChatAdmins;
import balashov.os.synchronizeratingbot.core.channel.memberstatus.ports.usecases.GetUserStatus;
import balashov.os.synchronizeratingbot.infrastructure.telegram.adapters.channel.mappers.TelegramMemberMapper;
import balashov.os.synchronizeratingbot.infrastructure.telegram.executors.TelegramClientProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChatAdministrators;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChatMember;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class ChatMembershipAdaptersFactory {
    private final TelegramClientProxy telegramClient;

    @Bean
    public GetChatAdmins getChatAdminsProvider(TelegramMemberMapper mapper) {
        return chat -> telegramClient.execute(GetChatAdministrators.builder().chatId(chat.id()).build())
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Bean
    public GetUserStatus getUserStatusProvider() {
        return (chat, user) -> Optional.of(GetChatMember.builder().chatId(chat.id()).userId(user.id()).build())
                .map(telegramClient::execute)
                .map(member -> MemberStatuses.fromString(member.getStatus()));
    }

    @Bean
    public CheckChatMembership checkChatMembershipProvider(GetUserStatus getUserStatusProvider) {
        return (chat, user) -> getUserStatusProvider.getStatus(chat, user)
                .filter(MemberStatuses::isMember)
                .isPresent();
    }

    @Bean
    public CheckAdminRole checkAdminRoleProvider(GetUserStatus getUserStatusProvider) {
        return (chat, user) -> getUserStatusProvider.getStatus(chat, user)
                .filter(MemberStatuses::isAdmin)
                .isPresent();
    }
}

package balashov.os.synchronizeratingbot.core.channel.memberstatus.application;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.ChatDto;
import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.MemberDto;
import balashov.os.synchronizeratingbot.core.channel.common.ports.usecases.GetMember;
import balashov.os.synchronizeratingbot.core.channel.memberstatus.ports.usecases.GetChatAdmins;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAdminsService implements GetChatAdmins {
    private final GetMember getMemberService;
    private final GetChatAdmins getSavedChannelAdmins;
    private final GetChatAdmins getChatAdminsProvider;


    public List<MemberDto> getAdmins(ChatDto chat) {
        var savedChannelAdmins = getSavedChannelAdmins.getAdmins(chat);
        var providedChannelAdmins = getChatAdminsProvider.getAdmins(chat);

        providedChannelAdmins
                .stream()
                .filter(admin -> savedChannelAdmins.stream().noneMatch(admin::equals))
                .parallel()
                .forEach(admin -> getMemberService.getChatMemberByChatAndUser(chat, admin.user()));
        return providedChannelAdmins;
    }
}

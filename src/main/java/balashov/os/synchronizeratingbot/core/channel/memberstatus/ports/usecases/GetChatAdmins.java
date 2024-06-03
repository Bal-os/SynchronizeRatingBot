package balashov.os.synchronizeratingbot.core.channel.memberstatus.ports.usecases;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.ChatDto;
import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.MemberDto;

import java.util.List;

public interface GetChatAdmins {
    List<MemberDto> getAdmins(ChatDto chat);
}

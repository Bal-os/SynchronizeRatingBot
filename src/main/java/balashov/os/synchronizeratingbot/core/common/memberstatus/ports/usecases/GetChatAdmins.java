package balashov.os.synchronizeratingbot.core.common.memberstatus.ports.usecases;

import balashov.os.synchronizeratingbot.core.common.chat.ports.ChatDto;
import balashov.os.synchronizeratingbot.core.common.member.ports.MemberDto;

import java.util.List;

public interface GetChatAdmins {
    List<MemberDto> getAdmins(ChatDto chat);
}

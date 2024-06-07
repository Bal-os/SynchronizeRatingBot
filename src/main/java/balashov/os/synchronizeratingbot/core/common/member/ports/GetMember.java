package balashov.os.synchronizeratingbot.core.common.member.ports;

import balashov.os.synchronizeratingbot.core.common.chat.ports.ChatDto;
import balashov.os.synchronizeratingbot.core.common.user.ports.UserDto;

import java.util.Optional;

public interface GetMember {
    Optional<MemberDto> getChatMemberByChatAndUser(ChatDto chat, UserDto user);
}

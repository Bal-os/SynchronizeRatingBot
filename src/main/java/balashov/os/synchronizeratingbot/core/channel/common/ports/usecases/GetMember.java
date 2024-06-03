package balashov.os.synchronizeratingbot.core.channel.common.ports.usecases;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.ChatDto;
import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.UserDto;
import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.MemberDto;

import java.util.Optional;

public interface GetMember {
    Optional<MemberDto> getChatMemberByChatAndUser(ChatDto chat, UserDto user);
}

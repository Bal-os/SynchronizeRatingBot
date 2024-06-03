package balashov.os.synchronizeratingbot.core.channel.common.ports.repository;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.MemberDto;

public interface SaveMemberRepository {
    void saveChatMember(MemberDto memberDto);
}

package balashov.os.synchronizeratingbot.core.common.member.ports;

public interface SaveMemberRepository {
    void saveChatMember(MemberDto memberDto);
}

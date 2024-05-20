package balashov.os.synchronizeratingbot.core.channelsadmin.ports.usecases;

public interface CheckChannelMembership {
    boolean isUserMember(long chatId, long userId);
}

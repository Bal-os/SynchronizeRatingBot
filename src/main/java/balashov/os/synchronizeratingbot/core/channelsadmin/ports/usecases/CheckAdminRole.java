package balashov.os.synchronizeratingbot.core.channelsadmin.ports.usecases;

public interface CheckAdminRole {
    boolean isUserAdmin(long chatId, long userId);
}

package balashov.os.synchronizeratingbot.core.channelsadmin.ports.services;

import java.util.List;

public interface ChannelAdminsService {
    void addChannelAdmin(long chatId, long adminId);
    void removeChannelAdmin(long chatId, long adminId);
    void updateChannelAdmins(long chatId, List<Long> adminsIds);
}

package balashov.os.synchronizeratingbot.core.channelsadmin.ports.usecases;

import java.util.List;

public interface GetAdministeredChannels {
    List<Long> getAdministeredChannels(long userId);
}

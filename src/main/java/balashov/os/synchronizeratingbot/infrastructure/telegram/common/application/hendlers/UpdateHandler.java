package balashov.os.synchronizeratingbot.infrastructure.telegram.common.application.hendlers;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface UpdateHandler {
    boolean canHandle(Update Update);

    void handleUpdate(Update Update);
}

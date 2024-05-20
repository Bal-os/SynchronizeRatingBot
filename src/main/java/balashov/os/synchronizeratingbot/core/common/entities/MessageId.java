package balashov.os.synchronizeratingbot.core.common.entities;

import lombok.Builder;

@Builder
public record MessageId(long messageId, long chatId) {
}

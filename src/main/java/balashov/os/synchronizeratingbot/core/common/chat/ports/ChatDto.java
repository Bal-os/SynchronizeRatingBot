package balashov.os.synchronizeratingbot.core.common.chat.ports;

import lombok.Builder;

@Builder
public record ChatDto(Long id,
                      String title) {
}
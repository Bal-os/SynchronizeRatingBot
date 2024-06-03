package balashov.os.synchronizeratingbot.core.channel.common.ports.entities;

import lombok.Builder;

@Builder
public record ChatDto(Long id,
                      String title) {
}
package balashov.os.synchronizeratingbot.core.channel.common.ports.entities;

import lombok.Builder;
import lombok.Getter;

@Builder
public record ChatDto(Long id,
                      String title) {}
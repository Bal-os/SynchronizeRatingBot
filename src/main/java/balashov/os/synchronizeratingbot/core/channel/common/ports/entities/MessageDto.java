package balashov.os.synchronizeratingbot.core.channel.common.ports.entities;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MessageDto(MessageId id,
                         List<PhotoDto> photosFromMessage,
                         UserDto sender,
                         ChatDto chat,
                         String text,
                         LocalDate localDate) {}
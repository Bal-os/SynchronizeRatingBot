package balashov.os.synchronizeratingbot.core.common.message.ports;

import balashov.os.synchronizeratingbot.core.common.chat.ports.ChatDto;
import balashov.os.synchronizeratingbot.core.common.photo.ports.PhotoDto;
import balashov.os.synchronizeratingbot.core.common.user.ports.UserDto;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MessageDto(MessageId id,
                         List<PhotoDto> photosFromMessage,
                         UserDto sender,
                         ChatDto chat,
                         String text,
                         LocalDate localDate) {
}
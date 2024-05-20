package balashov.os.synchronizeratingbot.infrastructure.sql.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@Embeddable
@RequiredArgsConstructor
public class MessageKey implements Serializable {
    @Column(name = "message_id", nullable = false)
    private Integer messageId;

    @Column(name = "chat_id", nullable = false)
    private Long chatId;
}

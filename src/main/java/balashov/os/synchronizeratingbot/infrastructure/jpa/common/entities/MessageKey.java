package balashov.os.synchronizeratingbot.infrastructure.jpa.common.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@Getter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MessageKey implements Serializable {
    @Column(name = "message_id", nullable = false)
    private Integer messageNumberInChat;

    @Column(nullable = false)
    private Long chatId;
}

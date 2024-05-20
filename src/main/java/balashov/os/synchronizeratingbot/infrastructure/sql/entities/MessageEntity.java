package balashov.os.synchronizeratingbot.infrastructure.sql.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Builder
@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class MessageEntity {
    @EmbeddedId
    @EqualsAndHashCode.Include
    private MessageKey id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity from;

    @ManyToOne
    @MapsId("chatId")
    @JoinColumn(name = "chat_id", nullable = false, insertable = false, updatable = false)
    private ChatEntity chat;

    @ManyToOne
    private ChatEntity forwardFromChat;

    @ManyToOne
    private UserEntity forwardFrom;

    private LocalDate date;
    private String text;
    private Long photoId;
}


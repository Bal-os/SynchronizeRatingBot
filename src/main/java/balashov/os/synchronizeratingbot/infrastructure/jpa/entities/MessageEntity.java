package balashov.os.synchronizeratingbot.infrastructure.jpa.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Entity
@SuperBuilder
@Getter
@Table(name = "messages")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
public class MessageEntity {
    @EmbeddedId
    @EqualsAndHashCode.Include
    private MessageKey id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
    private UserEntity sender;

    @ManyToOne
    @MapsId("chatId")
    @JoinColumn(name = "chat_id", nullable = false, insertable = false, updatable = false)
    private ChatEntity chat;

    @OneToMany(mappedBy = "message", fetch = FetchType.LAZY)
    private List<PhotoEntity> photos;

    private LocalDate localDate;
    private String text;
}


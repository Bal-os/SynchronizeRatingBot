package balashov.os.synchronizeratingbot.infrastructure.sql.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class ChatEntity {
    @Id
    @EqualsAndHashCode.Include
    private Long id;
    private Boolean isChannel;
    private String title;

    @OneToMany(mappedBy = "chat")
    private List<ChatUserEntity> chatUsers;

    @OneToMany(mappedBy = "chat")
    private List<MessageEntity> messages;
}

package balashov.os.synchronizeratingbot.infrastructure.sql.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Builder
@EqualsAndHashCode
@RequiredArgsConstructor
public class UserEntity {
    @Id
    @EqualsAndHashCode.Include
    private Long id;

    private String username;
    private String firstName;
    private String lastName;
    private Boolean isBot;
    private String languageCode;

    @OneToMany(mappedBy = "user")
    private List<ChatUserEntity> chatUsers;

    @OneToMany(mappedBy = "from")
    private List<MessageEntity> messages;
}

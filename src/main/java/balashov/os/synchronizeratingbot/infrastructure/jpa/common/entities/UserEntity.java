package balashov.os.synchronizeratingbot.infrastructure.jpa.common.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@SuperBuilder
@Getter
@Table(name = "users")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
public class UserEntity {
    @Id
    @EqualsAndHashCode.Include
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private Boolean isBot;
    private String phoneNumber;
    private String languageCode;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<PhotoEntity> photos;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<MemberEntity> chats;

    @OneToMany(mappedBy = "sender", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<MessageEntity> messages;
}

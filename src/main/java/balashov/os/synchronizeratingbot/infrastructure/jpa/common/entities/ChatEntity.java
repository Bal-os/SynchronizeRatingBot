package balashov.os.synchronizeratingbot.infrastructure.jpa.common.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter
@SuperBuilder
@Table(name = "chats")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@EqualsAndHashCode
@RequiredArgsConstructor
public class ChatEntity {
    @Id
    @EqualsAndHashCode.Include
    private Long id;
    private Boolean isChannel;
    private String title;

    @OneToMany(mappedBy = "chat", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<MemberEntity> chatMembers;

    @OneToMany(mappedBy = "chat", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<MessageEntity> messages;
}

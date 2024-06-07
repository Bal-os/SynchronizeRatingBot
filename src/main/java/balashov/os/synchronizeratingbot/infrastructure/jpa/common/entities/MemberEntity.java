package balashov.os.synchronizeratingbot.infrastructure.jpa.common.entities;

import balashov.os.synchronizeratingbot.core.common.memberstatus.ports.entities.MemberStatuses;
import balashov.os.synchronizeratingbot.infrastructure.jpa.common.converters.MemberStatusesConverter;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@SuperBuilder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
@Table(name = "members")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @EqualsAndHashCode.Include
    @JoinColumn(name = "chat_id")
    private ChatEntity chat;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @EqualsAndHashCode.Include
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    @EqualsAndHashCode.Include
    @Convert(converter = MemberStatusesConverter.class)
    private MemberStatuses status;
}

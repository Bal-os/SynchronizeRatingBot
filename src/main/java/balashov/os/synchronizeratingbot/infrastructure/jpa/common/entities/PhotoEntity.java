package balashov.os.synchronizeratingbot.infrastructure.jpa.common.entities;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@SuperBuilder
@Getter
@Table(name = "photos")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
public class PhotoEntity {
    @Id
    @EqualsAndHashCode.Include
    private String id;
    private String filePath;
    @EqualsAndHashCode.Include
    private String fileUniqueId;

    @ManyToOne(fetch = FetchType.LAZY)
    private MessageEntity message;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;
}
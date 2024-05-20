package balashov.os.synchronizeratingbot.infrastructure.sql.repositories;

import balashov.os.synchronizeratingbot.infrastructure.sql.entities.MessageEntity;
import balashov.os.synchronizeratingbot.infrastructure.sql.entities.MessageKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<MessageEntity, MessageKey> {
}

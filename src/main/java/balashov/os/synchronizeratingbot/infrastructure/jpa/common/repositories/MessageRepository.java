package balashov.os.synchronizeratingbot.infrastructure.jpa.common.repositories;

import balashov.os.synchronizeratingbot.infrastructure.jpa.common.entities.MessageEntity;
import balashov.os.synchronizeratingbot.infrastructure.jpa.common.entities.MessageKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, MessageKey> {
}

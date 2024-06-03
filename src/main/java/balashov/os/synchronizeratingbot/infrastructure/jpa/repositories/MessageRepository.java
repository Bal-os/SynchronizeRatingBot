package balashov.os.synchronizeratingbot.infrastructure.jpa.repositories;

import balashov.os.synchronizeratingbot.infrastructure.jpa.entities.MessageEntity;
import balashov.os.synchronizeratingbot.infrastructure.jpa.entities.MessageKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, MessageKey> {
}

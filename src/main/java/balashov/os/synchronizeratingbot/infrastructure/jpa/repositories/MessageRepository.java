package balashov.os.synchronizeratingbot.infrastructure.jpa.repositories;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.MessageDto;
import balashov.os.synchronizeratingbot.infrastructure.jpa.entities.MessageEntity;
import balashov.os.synchronizeratingbot.infrastructure.jpa.entities.MessageKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, MessageKey> {
}

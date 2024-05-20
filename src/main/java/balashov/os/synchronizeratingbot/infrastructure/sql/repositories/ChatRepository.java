package balashov.os.synchronizeratingbot.infrastructure.sql.repositories;

import balashov.os.synchronizeratingbot.infrastructure.sql.entities.ChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<ChatEntity, Long> {
}

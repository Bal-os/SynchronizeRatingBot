package balashov.os.synchronizeratingbot.infrastructure.jpa.common.repositories;

import balashov.os.synchronizeratingbot.infrastructure.jpa.common.entities.ChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<ChatEntity, Long> {
}

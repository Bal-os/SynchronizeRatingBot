package balashov.os.synchronizeratingbot.infrastructure.jpa.repositories;

import balashov.os.synchronizeratingbot.infrastructure.jpa.entities.ChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<ChatEntity, Long> {
}

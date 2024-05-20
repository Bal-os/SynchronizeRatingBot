package balashov.os.synchronizeratingbot.infrastructure.sql.repositories;

import balashov.os.synchronizeratingbot.infrastructure.sql.entities.ChatUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ChatUserRepository extends JpaRepository<ChatUserEntity, Long> {
    List<ChatUserEntity> findByUserIdAndStatusIn(Long userId, List<String> statuses);
    Optional<ChatUserEntity> findByChatIdAndUserId(Long chatId, Long userId);
    Optional<ChatUserEntity> findByChatIdAndUserIdAndStatus(Long chatId, Long userId, String status);
    Optional<ChatUserEntity> findByChatIdAndUserIdAndStatusIn(Long chatId, Long userId, List<String> statuses);

    @Modifying
    @Transactional
    @Query("update ChatUserEntity c set c.status = :status where c.chat.id = :chatId and c.user.id = :userId")
    void updateStatusByChatIdAndUserId(@Param("status") String status, @Param("chatId") Long chatId, @Param("userId") Long userId);
}
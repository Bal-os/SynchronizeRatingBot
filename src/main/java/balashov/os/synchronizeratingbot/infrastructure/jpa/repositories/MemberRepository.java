package balashov.os.synchronizeratingbot.infrastructure.jpa.repositories;

import balashov.os.synchronizeratingbot.core.channel.memberstatus.ports.entities.MemberStatuses;
import balashov.os.synchronizeratingbot.infrastructure.jpa.entities.ChatEntity;
import balashov.os.synchronizeratingbot.infrastructure.jpa.entities.MemberEntity;
import balashov.os.synchronizeratingbot.infrastructure.jpa.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    List<MemberEntity> findAllByUser(UserEntity user);
    List<MemberEntity> findByUserAndStatusIn(UserEntity user, List<MemberStatuses> statuses);
    List<MemberEntity> findByChatAndStatusIn(ChatEntity chat, List<MemberStatuses> statuses);
    Optional<MemberEntity> findByChatAndUserAndStatus(ChatEntity chat, UserEntity user, MemberStatuses status);
    Optional<MemberEntity> findByChatAndUser(ChatEntity chat, UserEntity user);
    Optional<MemberEntity> findByChatAndUserAndStatusIn(ChatEntity chat, UserEntity user, List<MemberStatuses> statuses);

    @Modifying
    @Transactional
    @Query("update MemberEntity c set c.status = :status where c.chat = :chat and c.user = :user")
    void updateStatusByChatAndUser(@Param("chat") ChatEntity chat, @Param("user") UserEntity user, @Param("status") MemberStatuses status);
}
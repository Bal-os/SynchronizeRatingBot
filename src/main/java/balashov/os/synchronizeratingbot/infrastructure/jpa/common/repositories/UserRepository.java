package balashov.os.synchronizeratingbot.infrastructure.jpa.common.repositories;

import balashov.os.synchronizeratingbot.infrastructure.jpa.common.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}

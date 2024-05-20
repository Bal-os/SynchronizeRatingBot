package balashov.os.synchronizeratingbot.infrastructure.sql.repositories;

import balashov.os.synchronizeratingbot.infrastructure.sql.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}

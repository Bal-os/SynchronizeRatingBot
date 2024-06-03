package balashov.os.synchronizeratingbot.infrastructure.jpa.repositories;

import balashov.os.synchronizeratingbot.infrastructure.jpa.entities.PhotoEntity;
import balashov.os.synchronizeratingbot.infrastructure.jpa.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends JpaRepository<PhotoEntity, String> {
    List<PhotoEntity> findAllByUser(UserEntity user);
}

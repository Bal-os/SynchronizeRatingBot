package balashov.os.synchronizeratingbot.core.common.photo.ports;

import java.util.Optional;

public interface GetPhotoById {
    Optional<PhotoDto> getPhotoById(String photoId);
}

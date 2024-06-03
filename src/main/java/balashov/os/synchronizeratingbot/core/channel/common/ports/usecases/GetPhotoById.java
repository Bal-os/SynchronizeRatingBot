package balashov.os.synchronizeratingbot.core.channel.common.ports.usecases;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.PhotoDto;

import java.util.Optional;

public interface GetPhotoById {
    Optional<PhotoDto> getPhotoById(String photoId);
}

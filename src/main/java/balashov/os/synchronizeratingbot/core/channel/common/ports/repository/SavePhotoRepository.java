package balashov.os.synchronizeratingbot.core.channel.common.ports.repository;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.PhotoDto;

public interface SavePhotoRepository {
    void savePhoto(PhotoDto photoDto);
}

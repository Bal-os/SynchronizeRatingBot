package balashov.os.synchronizeratingbot.core.channel.common.application;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.PhotoDto;
import balashov.os.synchronizeratingbot.core.channel.common.ports.repository.SavePhotoRepository;
import balashov.os.synchronizeratingbot.core.channel.common.ports.usecases.GetPhotoById;

import java.util.Optional;

public class GetPhotoService implements GetPhotoById {
    GetPhotoById GetPhotoByIdProvider;
    GetPhotoById GetSavedPhotoById;
    SavePhotoRepository savePhoto;

    @Override
    public Optional<PhotoDto> getPhotoById(String photoId) {
        var savedPhoto = GetSavedPhotoById.getPhotoById(photoId);
        var photo = GetPhotoByIdProvider.getPhotoById(photoId);

        if (savedPhoto.isEmpty() || !photo.map(savedPhoto.get()::equals).orElse(false)) {
            photo.ifPresent(savePhoto::savePhoto);
        }
        return photo;
    }
}

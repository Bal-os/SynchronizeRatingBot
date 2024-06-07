package balashov.os.synchronizeratingbot.core.common.photo;

import balashov.os.synchronizeratingbot.core.common.photo.ports.GetPhotoById;
import balashov.os.synchronizeratingbot.core.common.photo.ports.PhotoDto;
import balashov.os.synchronizeratingbot.core.common.photo.ports.SavePhotoRepository;

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

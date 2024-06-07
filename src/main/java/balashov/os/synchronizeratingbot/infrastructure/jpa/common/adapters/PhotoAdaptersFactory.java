package balashov.os.synchronizeratingbot.infrastructure.jpa.common.adapters;

import balashov.os.synchronizeratingbot.core.common.photo.ports.GetPhotoById;
import balashov.os.synchronizeratingbot.core.common.photo.ports.SavePhotoRepository;
import balashov.os.synchronizeratingbot.infrastructure.jpa.common.mappers.PhotoMapper;
import balashov.os.synchronizeratingbot.infrastructure.jpa.common.repositories.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class PhotoAdaptersFactory {
    private final PhotoRepository repository;
    private final PhotoMapper mapper;

    @Bean
    public SavePhotoRepository savePhotoRepository() {
        return photo -> repository.save(mapper.mapToEntity(photo));
    }

    @Bean
    public GetPhotoById getSavedPhotoById() {
        return photoId -> repository.findById(photoId)
                .map(mapper::mapToDto);
    }
}

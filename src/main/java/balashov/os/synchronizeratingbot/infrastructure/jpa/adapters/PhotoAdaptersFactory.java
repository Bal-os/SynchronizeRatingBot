package balashov.os.synchronizeratingbot.infrastructure.jpa.adapters;

import balashov.os.synchronizeratingbot.core.channel.common.ports.repository.SavePhotoRepository;
import balashov.os.synchronizeratingbot.core.channel.common.ports.usecases.GetPhotoById;
import balashov.os.synchronizeratingbot.infrastructure.jpa.mappers.PhotoMapper;
import balashov.os.synchronizeratingbot.infrastructure.jpa.repositories.PhotoRepository;
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

package balashov.os.synchronizeratingbot.core.channel.common.ports.entities;

import lombok.Builder;

import java.util.List;

@Builder(toBuilder = true)
public record UserDto(Long id,
                      String username,
                      String firstName,
                      String lastName,
                      String languageCode,
                      Boolean isBot,
                      List<PhotoDto> profilePhotos) {
}

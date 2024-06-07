package balashov.os.synchronizeratingbot.core.common.photo.ports;

import balashov.os.synchronizeratingbot.core.common.user.ports.UserDto;
import lombok.Builder;

@Builder
public record PhotoDto(String id,
                       String filePath,
                       String fileUniqueId,
                       boolean isProfilePhoto,
                       UserDto photoAuthor) {
}
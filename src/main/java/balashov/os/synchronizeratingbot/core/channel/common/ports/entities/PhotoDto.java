package balashov.os.synchronizeratingbot.core.channel.common.ports.entities;

import lombok.Builder;
import lombok.Getter;

@Builder
public record PhotoDto(String id,
                       String filePath,
                       String fileUniqueId,
                       boolean isProfilePhoto,
                       UserDto photoAuthor) {}
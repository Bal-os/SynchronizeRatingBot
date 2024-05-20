package balashov.os.synchronizeratingbot.core.channelsadmin.ports.entities;

import balashov.os.synchronizeratingbot.core.common.entities.MessageDto;
import balashov.os.synchronizeratingbot.core.common.entities.MessageId;
import balashov.os.synchronizeratingbot.core.eventschannel.ports.entities.Post;
import lombok.Builder;

@Builder
public record PostDto(MessageId id,
                      Post post) implements MessageDto {
}

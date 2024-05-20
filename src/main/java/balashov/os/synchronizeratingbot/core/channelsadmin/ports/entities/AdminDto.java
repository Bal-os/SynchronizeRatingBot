package balashov.os.synchronizeratingbot.core.channelsadmin.ports.entities;

import balashov.os.synchronizeratingbot.core.common.entities.UserDto;
import balashov.os.synchronizeratingbot.core.common.entities.MessageId;
import lombok.Builder;

import java.util.List;

@Builder
public record AdminDto(long id,
                       List<Long> administeredChannelsId,
                       List<MessageId> postsId) implements UserDto {
}

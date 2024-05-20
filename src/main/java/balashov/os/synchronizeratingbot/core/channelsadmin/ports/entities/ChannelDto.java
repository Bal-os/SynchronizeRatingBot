package balashov.os.synchronizeratingbot.core.channelsadmin.ports.entities;

import balashov.os.synchronizeratingbot.core.common.entities.ChatDto;
import balashov.os.synchronizeratingbot.core.common.entities.MessageId;
import lombok.Builder;

import java.util.List;

@Builder
public record ChannelDto(long id,
                         List<Long> adminsId,
                         List<MessageId> posts) implements ChatDto {
}

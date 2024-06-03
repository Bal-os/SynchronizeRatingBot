package balashov.os.synchronizeratingbot.core.channel.common.ports.usecases;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.MessageDto;
import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.PhotoDto;

import java.util.List;

public interface SavePhotosMessage {
    List<MessageDto> savePhotos(List<PhotoDto> photos);
}

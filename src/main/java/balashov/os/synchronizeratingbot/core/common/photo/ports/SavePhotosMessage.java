package balashov.os.synchronizeratingbot.core.common.photo.ports;

import balashov.os.synchronizeratingbot.core.common.message.ports.MessageDto;

import java.util.List;

public interface SavePhotosMessage {
    List<MessageDto> savePhotos(List<PhotoDto> photos);
}

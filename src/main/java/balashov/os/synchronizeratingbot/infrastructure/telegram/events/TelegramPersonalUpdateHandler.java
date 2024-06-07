package balashov.os.synchronizeratingbot.infrastructure.telegram.events;

import balashov.os.synchronizeratingbot.infrastructure.telegram.common.application.hendlers.MessageHandler;
import balashov.os.synchronizeratingbot.infrastructure.telegram.common.application.services.TelegramClientProxy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.LinkPreviewOptions;
import org.telegram.telegrambots.meta.api.objects.message.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

@Slf4j
@Service
@RequiredArgsConstructor
public class TelegramPersonalUpdateHandler implements MessageHandler {
    private final TelegramClientProxy executor;

    public void handleMessage(Message message) {
        ReplyKeyboardMarkup keyboard = ReplyKeyboardMarkup.builder()
                .keyboardRow(createButtonRow())
                .build();
        SendMessage sendMessage = SendMessage.builder()
                .chatId(message.getChatId())
                .linkPreviewOptions(LinkPreviewOptions.builder().isDisabled(true).build())
                .parseMode("MarkdownV2")
                .text("[Holy Tusa](https://t.me/holytusa)\n" +
                        "\n" +
                        "01\\.06 о 17:00 в [Panorama Bar](https://maps.app.goo.gl/wVXsKwacg6Morgs26)\n" +
                        "\n" +
                        "[Квитки](https://ottry.com/services/warp/big-student-party-01-06) \\(additional info)\n")
                .replyMarkup(keyboard)
                .build();
        executor.execute(sendMessage);
    }

    private KeyboardRow createButtonRow() {
        log.info("Creating button row");
        KeyboardButton button = KeyboardButton.builder()
                .text("Start")
                .build();

        return new KeyboardRow(button);
    }
}

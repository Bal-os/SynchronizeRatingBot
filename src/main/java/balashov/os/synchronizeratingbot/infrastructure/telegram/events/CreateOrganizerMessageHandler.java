package balashov.os.synchronizeratingbot.infrastructure.telegram.events;

import balashov.os.synchronizeratingbot.core.common.creationstates.ports.CreationStates;
import balashov.os.synchronizeratingbot.core.events.organizers.CreateOrganizerService;
import balashov.os.synchronizeratingbot.core.events.organizers.ports.entities.OrganizerCreationStates;
import balashov.os.synchronizeratingbot.core.events.organizers.ports.entities.OrganizerDto;
import balashov.os.synchronizeratingbot.infrastructure.telegram.common.application.services.TelegramClientProxy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Slf4j
//@Component
@RequiredArgsConstructor
public class CreateOrganizerMessageHandler {
    private final CreateOrganizerService stateMachine;
    private final TelegramClientProxy executor;


    private void processUserInput(Long chatId, String userInput, OrganizerCreationStates state) {
        switch (state) {
            case ADD_NAME -> stateMachine.addName(userInput);
            case ADD_INSTAGRAM_LINK -> stateMachine.addInstagramLink(userInput);
        }
        sendStateKeyboard(chatId, stateMachine.getCurrentState());
    }

    private void sendInputPrompt(Long chatId, String callbackData) {
        SendMessage message = SendMessage.builder()
                .chatId(chatId.toString())
                .text("Please enter the " + callbackData.substring(6).toLowerCase().replace('_', ' ') + ":")
                .build();
        executor.execute(message);
    }

    private void sendStateKeyboard(Long chatId, CreationStates state) {
        ReplyKeyboardMarkup keyboard = createKeyboard(state);
        SendMessage message = SendMessage.builder()
                .chatId(chatId.toString())
                .text("Please " + state.toString().toLowerCase().replace('_', ' ') + ":")
                .replyMarkup(keyboard)
                .build();
        executor.execute(message);
    }

    private void sendConfirmationMessage(Long chatId, OrganizerDto organizer, CreationStates finalState) {
        SendMessage message = SendMessage.builder()
                .chatId(chatId.toString())
                .text("Do you want to create organizer with the following data?\n" + organizer.toString())
                .replyMarkup(createKeyboard(finalState))
                .build();
        executor.execute(message);
    }

    private ReplyKeyboardMarkup createKeyboard(CreationStates state) {
        var organizerCreationStates = (OrganizerCreationStates) state;
        List<KeyboardRow> keyboard = new ArrayList<>();
        switch (organizerCreationStates) {
            case ADD_NAME:
                keyboard.add(createButtonRow("Enter Name", "ENTER_NAME"));
                break;
            case ADD_INSTAGRAM_LINK:
                keyboard.add(createButtonRow("Enter Instagram Link", "ENTER_INSTAGRAM_LINK"));
                keyboard.add(createButtonRow("Previous", "PREVIOUS"));
                keyboard.add(createButtonRow("Next", "NEXT"));
                break;
            case ADD_CHAT:
                keyboard.add(createButtonRow("Enter Chat", "ENTER_CHAT"));
                keyboard.add(createButtonRow("Previous", "PREVIOUS"));
                keyboard.add(createButtonRow("Next", "NEXT"));
                break;
            case ADD_CHANNEL:
                keyboard.add(createButtonRow("Enter Channel", "ENTER_CHANNEL"));
                keyboard.add(createButtonRow("Previous", "PREVIOUS"));
                keyboard.add(createButtonRow("Next", "NEXT"));
                break;
            case CHOOSE_EVENTS_TO_ADD:
                keyboard.add(createButtonRow("Choose Events to Add", "CHOOSE_EVENTS_TO_ADD"));
                keyboard.add(createButtonRow("Previous", "PREVIOUS"));
                keyboard.add(createButtonRow("Next", "NEXT"));
                break;
            case ADD_USERS_TO_ADD:
                keyboard.add(createButtonRow("Enter User to Add", "ENTER_USER"));
                keyboard.add(createButtonRow("Previous", "PREVIOUS"));
                keyboard.add(createButtonRow("Next", "NEXT"));
                break;
            case CONFIRMATION:
                keyboard.add(createButtonRow("Confirm", "CONFIRMATION"));
                keyboard.add(createButtonRow("Previous", "PREVIOUS"));
                break;
        }

        return new ReplyKeyboardMarkup(keyboard);
    }

    private KeyboardRow createButtonRow(String text, String callbackData) {
        KeyboardButton button = KeyboardButton.builder()
                .text(text)
                .build();

        return new KeyboardRow(button);
    }
}

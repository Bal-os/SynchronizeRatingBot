package balashov.os.synchronizeratingbot.core.common.memberstatus.services;

import balashov.os.synchronizeratingbot.core.common.chat.ports.ChatDto;
import balashov.os.synchronizeratingbot.core.common.memberstatus.ports.entities.MemberStatuses;
import balashov.os.synchronizeratingbot.core.common.memberstatus.ports.repossitories.SaveUserStatusRepository;
import balashov.os.synchronizeratingbot.core.common.memberstatus.ports.repossitories.UpdateUserStatusRepository;
import balashov.os.synchronizeratingbot.core.common.memberstatus.ports.usecases.GetUserStatus;
import balashov.os.synchronizeratingbot.core.common.user.ports.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetUserStatusService implements GetUserStatus {
    private final GetUserStatus getSavedUserStatus;
    private final GetUserStatus getUserStatusProvider;
    private final UpdateUserStatusRepository updateStatus;
    private final SaveUserStatusRepository saveStatus;

    @Override
    public Optional<MemberStatuses> getStatus(ChatDto chat, UserDto user) {
        return getUserStatusProvider.getStatus(chat, user)
                .stream()
                .peek(memberStatuses -> updateStatus(chat, user, memberStatuses))
                .findFirst();
    }

    private void updateStatus(ChatDto chat, UserDto user, MemberStatuses status) {
        var savedUserStatus = getSavedUserStatus.getStatus(chat, user);

        if (savedUserStatus.isEmpty()) {
            saveStatus.saveUserStatus(chat, user, status);
        } else if (status.equals(savedUserStatus.get())) {
            updateStatus.update(chat, user, status);
        }
    }
}

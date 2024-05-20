package balashov.os.synchronizeratingbot.infrastructure.sql.adapters;

import balashov.os.synchronizeratingbot.core.channelsadmin.ports.entities.MemberStatuses;
import balashov.os.synchronizeratingbot.core.channelsadmin.ports.repositories.GetUserStatusRepository;
import balashov.os.synchronizeratingbot.core.channelsadmin.ports.repositories.SaveUserStatusRepository;
import balashov.os.synchronizeratingbot.core.channelsadmin.ports.usecases.CheckAdminRole;
import balashov.os.synchronizeratingbot.core.channelsadmin.ports.usecases.CheckChannelMembership;
import balashov.os.synchronizeratingbot.core.channelsadmin.ports.usecases.GetAdministeredChannels;
import balashov.os.synchronizeratingbot.core.common.entities.ChatDto;
import balashov.os.synchronizeratingbot.core.common.entities.MessageDto;
import balashov.os.synchronizeratingbot.core.common.entities.UserDto;
import balashov.os.synchronizeratingbot.core.common.usecases.GetChatById;
import balashov.os.synchronizeratingbot.core.common.usecases.GetMessageById;
import balashov.os.synchronizeratingbot.core.common.usecases.GetUserById;
import balashov.os.synchronizeratingbot.infrastructure.mapstruct.ChatMapper;
import balashov.os.synchronizeratingbot.infrastructure.mapstruct.MessageIdMapper;
import balashov.os.synchronizeratingbot.infrastructure.mapstruct.MessageMapper;
import balashov.os.synchronizeratingbot.infrastructure.mapstruct.UserMapper;
import balashov.os.synchronizeratingbot.infrastructure.sql.entities.ChatUserEntity;
import balashov.os.synchronizeratingbot.infrastructure.sql.repositories.ChatRepository;
import balashov.os.synchronizeratingbot.infrastructure.sql.repositories.ChatUserRepository;
import balashov.os.synchronizeratingbot.infrastructure.sql.repositories.MessageRepository;
import balashov.os.synchronizeratingbot.infrastructure.sql.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdaptersFactory {
    @Bean
    public SaveUserStatusRepository saveUserStatus(ChatUserRepository chatUserRepository) {
        return (chatId, userId, status) ->
                chatUserRepository.updateStatusByChatIdAndUserId(status.toString(), chatId, userId);
    }

    @Bean
    public GetUserStatusRepository getUserStatus(ChatUserRepository chatUserRepository) {
        return (chatId, userId) -> chatUserRepository.findByChatIdAndUserId(chatId, userId)
                .map(ChatUserEntity::getStatus)
                .map(MemberStatuses::fromString);
    }

    @Bean
    public GetAdministeredChannels getAdministeredChannels(ChatUserRepository chatUserRepository) {
        return userId ->
                chatUserRepository.findByUserIdAndStatusIn(userId, MemberStatuses.getAdminStatuses()).parallelStream()
                        .map(chatUserEntity -> chatUserEntity.getChat().getId())
                        .toList();
    }

    @Bean
    public CheckAdminRole checkAdminRole(ChatUserRepository chatUserRepository) {
        return (chatId, userId) ->
                chatUserRepository.findByChatIdAndUserIdAndStatusIn(chatId, userId, MemberStatuses.getAdminStatuses())
                        .isPresent();
    }

    @Bean
    public CheckChannelMembership checkChannelMembership(ChatUserRepository chatUserRepository) {
        return (chatId, userId) ->
                chatUserRepository.findByChatIdAndUserIdAndStatusIn(chatId, userId, MemberStatuses.getMemberStatuses())
                        .isPresent();
    }

    @Bean
    public GetUserById getUserById(UserRepository userRepository, UserMapper userMapper) {
        return userId -> userRepository.findById(userId)
                .map(userMapper::mapToDto)
                .map(UserDto.class::cast)
                .orElse(() -> userId);
    }

    @Bean
    public GetChatById getChatById(ChatRepository chatRepository, ChatMapper chatMapper) {
        return chatId -> chatRepository.findById(chatId)
                .map(chatMapper::mapToDto)
                .map(ChatDto.class::cast)
                .orElse(() -> chatId);
    }

    @Bean
    public GetMessageById getMessageById(MessageRepository messageRepository,
                                         MessageMapper messageMapper,
                                         MessageIdMapper messageIdMapper) {
        return messageId -> messageRepository.findById(messageIdMapper.mapToMessageKey(messageId))
                .map(messageMapper::mapToDto).map(MessageDto.class::cast)
                .orElse(() -> messageId);
    }
}

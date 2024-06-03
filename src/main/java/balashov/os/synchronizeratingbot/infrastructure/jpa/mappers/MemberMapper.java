package balashov.os.synchronizeratingbot.infrastructure.jpa.mappers;

import balashov.os.synchronizeratingbot.core.channel.common.ports.entities.MemberDto;
import balashov.os.synchronizeratingbot.infrastructure.jpa.entities.MemberEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    MemberDto mapToDto(MemberEntity memberEntity);
    MemberEntity mapToEntity(MemberDto memberDto);
}
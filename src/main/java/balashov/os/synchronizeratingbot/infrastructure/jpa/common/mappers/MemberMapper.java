package balashov.os.synchronizeratingbot.infrastructure.jpa.common.mappers;

import balashov.os.synchronizeratingbot.core.common.member.ports.MemberDto;
import balashov.os.synchronizeratingbot.infrastructure.jpa.common.entities.MemberEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {
    MemberDto mapToDto(MemberEntity memberEntity);

    MemberEntity mapToEntity(MemberDto memberDto);
}
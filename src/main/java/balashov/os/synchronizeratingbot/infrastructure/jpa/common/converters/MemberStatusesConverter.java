package balashov.os.synchronizeratingbot.infrastructure.jpa.common.converters;

import balashov.os.synchronizeratingbot.core.common.memberstatus.ports.entities.MemberStatuses;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class MemberStatusesConverter implements AttributeConverter<MemberStatuses, String> {
    public MemberStatusesConverter() {
    }

    @Override
    public String convertToDatabaseColumn(MemberStatuses attribute) {
        return attribute.toString();
    }

    @Override
    public MemberStatuses convertToEntityAttribute(String dbData) {
        return MemberStatuses.fromString(dbData);
    }
}

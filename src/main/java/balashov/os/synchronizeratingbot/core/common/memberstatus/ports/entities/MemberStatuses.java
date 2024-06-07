package balashov.os.synchronizeratingbot.core.common.memberstatus.ports.entities;

import java.util.Arrays;
import java.util.List;

public enum MemberStatuses {
    CREATOR,
    ADMINISTRATOR,
    MEMBER,
    LEFT,
    KICKED,
    RESTRICTED;

    private static final List<MemberStatuses> adminStatuses = List.of(ADMINISTRATOR, CREATOR);

    public static MemberStatuses fromString(String status) {
        return Arrays.stream(values())
                .filter(value -> value.toString().equalsIgnoreCase(status))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown status: " + status));
    }

    public static boolean isAdmin(MemberStatuses status) {
        return admins().contains(status);
    }

    public static boolean isMember(MemberStatuses status) {
        return members().contains(status);
    }

    public static boolean isCreator(MemberStatuses status) {
        return CREATOR.equals(status);
    }

    public static List<MemberStatuses> admins() {
        return adminStatuses;
    }

    public static List<MemberStatuses> members() {
        MemberStatuses[] memberStatuses = {MEMBER};
        admins().toArray(memberStatuses);
        return List.of(memberStatuses);
    }

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
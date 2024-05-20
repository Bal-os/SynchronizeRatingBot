package balashov.os.synchronizeratingbot.core.channelsadmin.ports.entities;

import java.util.Arrays;
import java.util.List;

public enum MemberStatuses {
    CREATOR,
    ADMINISTRATOR,
    MEMBER,
    LEFT,
    KICKED,
    RESTRICTED;

    private static final List<MemberStatuses> adminStatuses = List.of(CREATOR, ADMINISTRATOR);
    private static final List<MemberStatuses> notMemberStatuses = List.of(LEFT, KICKED, RESTRICTED);

    public static MemberStatuses fromString(String status) {
        return Arrays.stream(values())
                .filter(value -> value.toString().equalsIgnoreCase(status))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown status: " + status));
    }

    public static boolean isMemberStatus(String status) {
        return !isContains(status, notMemberStatuses);
    }

    public static boolean isAdminStatus(String status) {
        return isContains(status, adminStatuses);
    }

    public static boolean isCreatorStatus(String status) {
        return CREATOR.toString().equalsIgnoreCase(status);
    }
    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
    public static List<String> getAdminStatuses() {
        return adminStatuses.stream().map(Enum::toString).toList();
    }

    public static List<String> getMemberStatuses() {
        return Arrays.stream(values())
                .filter(value -> !notMemberStatuses.contains(value))
                .map(Enum::toString)
                .toList();
    }

    private static boolean isContains(String status, List<MemberStatuses> statuses) {
        return statuses.parallelStream()
                .map(Enum::toString)
                .anyMatch(status::equalsIgnoreCase);
    }
}
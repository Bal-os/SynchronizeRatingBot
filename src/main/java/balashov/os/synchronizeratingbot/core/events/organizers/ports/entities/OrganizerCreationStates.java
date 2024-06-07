package balashov.os.synchronizeratingbot.core.events.organizers.ports.entities;

import balashov.os.synchronizeratingbot.core.common.creationstates.ports.CreationStates;

import java.util.Optional;

public enum OrganizerCreationStates implements CreationStates<OrganizerCreationStates> {
    START {
        @Override
        public boolean isInitial() {
            return true;
        }

        @Override
        public Optional<OrganizerCreationStates> next() {
            return Optional.of(ADD_NAME);
        }
    },
    ADD_NAME {
        @Override
        public Optional<OrganizerCreationStates> next() {
            return Optional.of(ADD_INSTAGRAM_LINK);
        }

        @Override
        public Optional<OrganizerCreationStates> previous() {
            return Optional.of(START);
        }
    },
    ADD_INSTAGRAM_LINK {
        @Override
        public Optional<OrganizerCreationStates> next() {
            return Optional.of(ADD_CHAT);
        }

        @Override
        public Optional<OrganizerCreationStates> previous() {
            return Optional.of(ADD_NAME);
        }
    },
    ADD_CHAT {
        @Override
        public Optional<OrganizerCreationStates> next() {
            return Optional.of(ADD_CHANNEL);
        }

        @Override
        public Optional<OrganizerCreationStates> previous() {
            return Optional.of(ADD_INSTAGRAM_LINK);
        }
    },
    ADD_CHANNEL {
        @Override
        public Optional<OrganizerCreationStates> next() {
            return Optional.of(CHOOSE_EVENTS_TO_ADD);
        }

        @Override
        public Optional<OrganizerCreationStates> previous() {
            return Optional.of(ADD_CHAT);
        }
    },
    CHOOSE_EVENTS_TO_ADD {
        @Override
        public Optional<OrganizerCreationStates> next() {
            return Optional.of(ADD_USERS_TO_ADD);
        }

        @Override
        public Optional<OrganizerCreationStates> previous() {
            return Optional.of(ADD_CHANNEL);
        }
    },
    ADD_USERS_TO_ADD {
        @Override
        public Optional<OrganizerCreationStates> next() {
            return Optional.of(CONFIRMATION);
        }

        @Override
        public Optional<OrganizerCreationStates> previous() {
            return Optional.of(CHOOSE_EVENTS_TO_ADD);
        }
    },
    CONFIRMATION {
        @Override
        public Optional<OrganizerCreationStates> previous() {
            return Optional.of(ADD_USERS_TO_ADD);
        }

        @Override
        public boolean isFinal() {
            return true;
        }
    };

    @Override
    public Optional<OrganizerCreationStates> next() {
        return Optional.empty();
    }

    @Override
    public Optional<OrganizerCreationStates> previous() {
        return Optional.empty();
    }

    @Override
    public boolean isFinal() {
        return false;
    }

    @Override
    public boolean isInitial() {
        return false;
    }
}

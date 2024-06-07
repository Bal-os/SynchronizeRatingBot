package balashov.os.synchronizeratingbot.core.events.events.ports.entities;

import balashov.os.synchronizeratingbot.core.common.creationstates.ports.CreationStates;

import java.util.Optional;

public enum EventCreationStates implements CreationStates<EventCreationStates> {
    ADD_NAME {
        @Override
        public boolean isInitial() {
            return true;
        }

        @Override
        public Optional<EventCreationStates> next() {
            return Optional.of(ADD_LINK);
        }
    },
    ADD_LINK {
        @Override
        public Optional<EventCreationStates> previous() {
            return Optional.of(ADD_NAME);
        }

        @Override
        public Optional<EventCreationStates> next() {
            return Optional.of(ADD_EVENT_DATE);
        }
    },
    CHOOSE_OR_ADD_ORGANIZER {
        @Override
        public Optional<EventCreationStates> previous() {
            return Optional.of(ADD_LINK);
        }

        @Override
        public Optional<EventCreationStates> next() {
            return Optional.of(ADD_EVENT_DATE);
        }
    },
    ADD_EVENT_DATE {
        @Override
        public Optional<EventCreationStates> previous() {
            return Optional.of(CHOOSE_OR_ADD_ORGANIZER);
        }

        @Override
        public Optional<EventCreationStates> next() {
            return Optional.of(ADD_EVENT_TIME);
        }

    },
    ADD_EVENT_TIME {
        @Override
        public Optional<EventCreationStates> previous() {
            return Optional.of(ADD_EVENT_DATE);
        }

        @Override
        public Optional<EventCreationStates> next() {
            return Optional.of(CHOOSE_OR_ADD_LOCATION);
        }
    },
    CHOOSE_OR_ADD_LOCATION {
        @Override
        public Optional<EventCreationStates> previous() {
            return Optional.of(ADD_EVENT_TIME);
        }

        @Override
        public Optional<EventCreationStates> next() {
            return Optional.of(IS_FREE);
        }
    },
    IS_FREE {
        @Override
        public Optional<EventCreationStates> previous() {
            return Optional.of(CHOOSE_OR_ADD_LOCATION);
        }

        @Override
        public Optional<EventCreationStates> next() {
            return Optional.of(IS_CHARITY);
        }
    },
    IS_CHARITY {
        @Override
        public Optional<EventCreationStates> previous() {
            return Optional.of(IS_FREE);
        }

        @Override
        public Optional<EventCreationStates> next() {
            return Optional.of(ADD_TICKET_LINK);
        }
    },
    ADD_TICKET_LINK {
        @Override
        public Optional<EventCreationStates> previous() {
            return Optional.of(ADD_LINK);
        }

        @Override
        public Optional<EventCreationStates> next() {
            return Optional.of(ADD_PHOTO);
        }
    },
    ADD_PHOTO {
        @Override
        public Optional<EventCreationStates> previous() {
            return Optional.of(ADD_TICKET_LINK);
        }

        @Override
        public Optional<EventCreationStates> next() {
            return Optional.of(ADDITIONAL_INFO);
        }
    },
    ADDITIONAL_INFO {
        @Override
        public Optional<EventCreationStates> previous() {
            return Optional.of(ADD_PHOTO);
        }

        @Override
        public Optional<EventCreationStates> next() {
            return Optional.of(CONFIRMATION);
        }
    },
    CONFIRMATION {
        @Override
        public Optional<EventCreationStates> previous() {
            return Optional.of(ADDITIONAL_INFO);
        }

        @Override
        public boolean isFinal() {
            return true;
        }
    };

    @Override
    public Optional<EventCreationStates> next() {
        return Optional.empty();
    }

    @Override
    public Optional<EventCreationStates> previous() {
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

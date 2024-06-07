package balashov.os.synchronizeratingbot.core.events.locations.ports.entities;

import balashov.os.synchronizeratingbot.core.common.creationstates.ports.CreationStates;

import java.util.Optional;

public enum LocationCreationStates implements CreationStates<LocationCreationStates> {
    ADD_NAME {
        @Override
        public boolean isInitial() {
            return true;
        }

        @Override
        public Optional<LocationCreationStates> next() {
            return Optional.of(ADD_GOOGLE_MAPS_LINK);
        }
    },
    ADD_GOOGLE_MAPS_LINK {
        @Override
        public Optional<LocationCreationStates> previous() {
            return Optional.of(ADD_NAME);
        }

        @Override
        public Optional<LocationCreationStates> next() {
            return Optional.of(ADD_TYPE);
        }
    },
    ADD_TYPE {
        @Override
        public Optional<LocationCreationStates> previous() {
            return Optional.of(ADD_GOOGLE_MAPS_LINK);
        }

        @Override
        public Optional<LocationCreationStates> next() {
            return Optional.of(ADD_ADDRESS);
        }
    },
    ADD_ADDRESS {
        @Override
        public Optional<LocationCreationStates> previous() {
            return Optional.of(ADD_TYPE);
        }

        @Override
        public Optional<LocationCreationStates> next() {
            return Optional.of(ADD_INSTAGRAM_LINK);
        }
    },
    ADD_INSTAGRAM_LINK {
        @Override
        public Optional<LocationCreationStates> previous() {
            return Optional.of(ADD_ADDRESS);
        }

        @Override
        public Optional<LocationCreationStates> next() {
            return Optional.of(ADD_TELEGRAM_LINK);
        }
    },
    ADD_TELEGRAM_LINK {
        @Override
        public Optional<LocationCreationStates> previous() {
            return Optional.of(ADD_INSTAGRAM_LINK);
        }

        @Override
        public Optional<LocationCreationStates> next() {
            return Optional.of(ADD_NUMBER);
        }
    },
    ADD_NUMBER {
        @Override
        public Optional<LocationCreationStates> previous() {
            return Optional.of(ADD_TELEGRAM_LINK);
        }

        @Override
        public Optional<LocationCreationStates> next() {
            return Optional.of(CONFIRMATION);
        }
    },
    CONFIRMATION {
        @Override
        public Optional<LocationCreationStates> previous() {
            return Optional.of(ADD_NUMBER);
        }

        @Override
        public boolean isFinal() {
            return true;
        }
    };

    @Override
    public Optional<LocationCreationStates> next() {
        return Optional.empty();
    }

    @Override
    public Optional<LocationCreationStates> previous() {
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
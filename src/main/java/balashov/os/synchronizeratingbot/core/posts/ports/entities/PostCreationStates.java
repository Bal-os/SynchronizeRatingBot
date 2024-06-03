package balashov.os.synchronizeratingbot.core.posts.ports.entities;

import balashov.os.synchronizeratingbot.core.creationstates.CreationStates;

import java.util.Optional;

public enum PostCreationStates implements CreationStates<PostCreationStates> {
    CREATION_STARTED {
        @Override
        public boolean isInitial() {
            return true;
        }

        @Override
        public Optional<PostCreationStates> next() {
            return Optional.of(ADD_CONTENT);
        }
    },
    ADD_CONTENT {
        @Override
        public Optional<PostCreationStates> previous() {
            return Optional.of(CREATION_STARTED);
        }

        @Override
        public Optional<PostCreationStates> next() {
            return Optional.of(CHOOSE_CHANNEL);
        }
    },
    CHOOSE_CHANNEL {
        @Override
        public Optional<PostCreationStates> previous() {
            return Optional.of(ADD_CONTENT);
        }

        @Override
        public Optional<PostCreationStates> next() {
            return Optional.of(ADD_RATING);
        }
    },
    ADD_RATING {
        @Override
        public Optional<PostCreationStates> previous() {
            return Optional.of(CHOOSE_CHANNEL);
        }

        @Override
        public Optional<PostCreationStates> next() {
            return Optional.of(SCHEDULE_PUBLICATION);
        }
    },
    SCHEDULE_PUBLICATION {
        @Override
        public Optional<PostCreationStates> previous() {
            return Optional.of(ADD_RATING);
        }

        @Override
        public boolean isFinal() {
            return true;
        }
    };

    @Override
    public Optional<PostCreationStates> next() {
        return Optional.empty();
    }

    @Override
    public Optional<PostCreationStates> previous() {
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

package balashov.os.synchronizeratingbot.core.creationstates;

import java.util.Optional;

public interface CreationStates<V extends CreationStates<V>> {
    Optional<V> next();

    Optional<V> previous();

    boolean isFinal();

    boolean isInitial();
}


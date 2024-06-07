package balashov.os.synchronizeratingbot.core.common.creationstates.ports;

import java.util.Optional;

public interface CreationStates<T extends Enum<T> & CreationStates<T>> {
    Optional<T> next();

    Optional<T> previous();

    boolean isFinal();

    boolean isInitial();
}


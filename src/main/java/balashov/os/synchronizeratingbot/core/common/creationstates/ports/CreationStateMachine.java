package balashov.os.synchronizeratingbot.core.common.creationstates.ports;

import java.util.Optional;

public interface CreationStateMachine<E extends Record, T extends Enum<T> & CreationStates<T>> {
    T getCurrentState();

    void restart();

    void transitionToNextState();

    void transitionToPreviousState();

    Optional<E> create();
}

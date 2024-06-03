package balashov.os.synchronizeratingbot.core.creationstates;

public interface CreationStateMachine<T extends CreationStates<T>> {
    T getCurrentState();

    void restart();

    void transitionToNextState();

    void transitionToPreviousState();
}

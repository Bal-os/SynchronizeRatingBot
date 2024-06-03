package balashov.os.synchronizeratingbot.core.creationstates;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;
import java.util.function.Function;

@Getter
@Setter(AccessLevel.PROTECTED)
public abstract class AbstractCreateStateMachine<T extends CreationStates<T>> implements CreationStateMachine<T> {
    private T currentState;

    @Override
    public void transitionToNextState() {
        transition(CreationStates::next);
    }

    @Override
    public void transitionToPreviousState() {
        transition(CreationStates::previous);
    }

    protected void transition(Function<T, Optional<T>> func) {
        func.apply(currentState).ifPresent(this::setCurrentState);
    }
}

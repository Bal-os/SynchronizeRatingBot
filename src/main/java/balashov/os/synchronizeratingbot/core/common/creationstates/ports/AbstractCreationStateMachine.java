package balashov.os.synchronizeratingbot.core.common.creationstates.ports;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;

@Getter
@Setter(AccessLevel.PROTECTED)
public abstract class AbstractCreationStateMachine<E extends Record, T extends Enum<T> & CreationStates<T>> implements CreationStateMachine<E, T> {
    private T currentState;

    @Override
    public void restart() {
        Arrays.stream(currentState.getDeclaringClass().getEnumConstants())
                .filter(CreationStates::isInitial)
                .findFirst()
                .ifPresent(this::setCurrentState);
    }

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

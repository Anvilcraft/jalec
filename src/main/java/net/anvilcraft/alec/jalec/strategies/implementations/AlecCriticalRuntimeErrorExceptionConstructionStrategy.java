package net.anvilcraft.alec.jalec.strategies.implementations;

import net.anvilcraft.alec.jalec.exceptions.AlecCriticalRuntimeErrorException;
import net.anvilcraft.alec.jalec.strategies.interfaces.IAlecExceptionContructionStrategy;

public class AlecCriticalRuntimeErrorExceptionConstructionStrategy
    implements IAlecExceptionContructionStrategy<AlecCriticalRuntimeErrorException> {
    @Override
    public AlecCriticalRuntimeErrorException constructAlecException(
        String message, Throwable cause, Class<AlecCriticalRuntimeErrorException> alecExceptionClass
    ) {
        if (!alecExceptionClass.isAssignableFrom(AlecCriticalRuntimeErrorException.class)) {
            throw this.constructAlecException(
                "Invalid exception class", null, AlecCriticalRuntimeErrorException.class
            );
        }
        return new AlecCriticalRuntimeErrorException(message, cause);
    }
}

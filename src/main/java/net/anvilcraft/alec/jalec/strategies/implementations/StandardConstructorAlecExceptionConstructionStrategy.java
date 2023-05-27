package net.anvilcraft.alec.jalec.strategies.implementations;

import net.anvilcraft.alec.jalec.IAlecException;
import net.anvilcraft.alec.jalec.factories.AlecCriticalRuntimeErrorExceptionFactory;
import net.anvilcraft.alec.jalec.strategies.interfaces.IAlecExceptionContructionStrategy;

public class StandardConstructorAlecExceptionConstructionStrategy<E extends IAlecException>
    implements IAlecExceptionContructionStrategy<E> {
    @Override
    public E constructAlecException(String message, Throwable cause, Class<E> alecExceptionClass) {
        try {
            return alecExceptionClass.getConstructor(String.class, Throwable.class)
                .newInstance(message, cause);
        } catch (Exception e) {
            throw AlecCriticalRuntimeErrorExceptionFactory.PLAIN.createAlecExceptionWithCause(
                e, "Error while constructing ALEC exception"
            );
        }
    }
}

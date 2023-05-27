package net.anvilcraft.alec.jalec.strategies.implementations;

import java.lang.reflect.Constructor;

import net.anvilcraft.alec.jalec.IAlecException;
import net.anvilcraft.alec.jalec.factories.AlecCriticalRuntimeErrorExceptionFactory;
import net.anvilcraft.alec.jalec.strategies.interfaces.IAlecExceptionContructionStrategy;

public class StandardConstructorAlecExceptionConstructionStrategy<E extends IAlecException>
    implements IAlecExceptionContructionStrategy<E> {
    @Override
    public E constructAlecException(String message, Throwable cause, Class<E> alecExceptionClass) {
        try {
            Constructor<E> constructor
                = alecExceptionClass.getConstructor(String.class, Throwable.class);

            constructor.setAccessible(true);

            return constructor.newInstance(message, cause);
        } catch (Exception e) {
            throw AlecCriticalRuntimeErrorExceptionFactory.PLAIN.createAlecExceptionWithCause(
                e, "Error while constructing ALEC exception"
            );
        }
    }
}

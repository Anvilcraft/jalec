package net.anvilcraft.alec.jalec.strategies.interfaces;

import net.anvilcraft.alec.jalec.IAlecException;

public interface IAlecExceptionContructionStrategy<E extends IAlecException> {
    public E constructAlecException(String message, Throwable cause, Class<E> alecExceptionClass);
}

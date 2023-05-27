package net.anvilcraft.alec.jalec.factories;

import net.anvilcraft.alec.jalec.IAlecException;

public abstract class AbstractAlecExceptionFactory<E extends IAlecException> {
    public abstract E createAlecExceptionWithCause(Throwable cause, Object... args);

    public E createAlecException(Object... args) {
        return this.createAlecExceptionWithCause(null, args);
    }
}

package net.anvilcraft.alec.jalec.exceptions;

import net.anvilcraft.alec.jalec.IAlecException;
import net.anvilcraft.alec.jalec.factories.AlecCriticalRuntimeErrorExceptionFactory;

public abstract class AbstractAlecRuntimeException
    extends RuntimeException implements IAlecException {
    protected AbstractAlecRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getAlecPrefix(boolean hasMessage) {
        return "ALEC";
    }

    @Override
    public String getMessage() {
        String prefix = this.getAlecPrefix(super.getMessage() != null);
        if (!prefix.contains("ALEC")) {
            throw AlecCriticalRuntimeErrorExceptionFactory.PLAIN.createAlecException(
                "Alec prefix missing ALEC"
            );
        }

        if (super.getMessage() == null)
            return prefix;
        return prefix + ": " + super.getMessage();
    }
}

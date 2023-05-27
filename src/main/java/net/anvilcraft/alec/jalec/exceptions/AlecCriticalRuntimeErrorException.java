package net.anvilcraft.alec.jalec.exceptions;

public class AlecCriticalRuntimeErrorException extends AbstractAlecRuntimeException {
    public AlecCriticalRuntimeErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getAlecPrefix(boolean hasMessage) {
        return "CRITICAL ALEC";
    }
}

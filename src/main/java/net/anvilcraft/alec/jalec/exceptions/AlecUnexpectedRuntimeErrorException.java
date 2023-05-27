package net.anvilcraft.alec.jalec.exceptions;

public class AlecUnexpectedRuntimeErrorException extends AbstractAlecRuntimeException {
    protected AlecUnexpectedRuntimeErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    @Override
    public String getAlecPrefix(boolean hasMessage) {
        return hasMessage ? "ALEC" : "Unexpected runtime ALEC; no further information";
    }
}

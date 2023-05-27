package net.anvilcraft.alec.jalec.factories;

import net.anvilcraft.alec.jalec.exceptions.AlecUnexpectedRuntimeErrorException;
import net.anvilcraft.alec.jalec.strategies.implementations.FormatStringAlecMessageGeneratorStrategy;
import net.anvilcraft.alec.jalec.strategies.implementations.PlainAlecMessageGeneratorStrategy;
import net.anvilcraft.alec.jalec.strategies.implementations.StandardConstructorAlecExceptionConstructionStrategy;
import net.anvilcraft.alec.jalec.strategies.interfaces.IAlecExceptionContructionStrategy;
import net.anvilcraft.alec.jalec.strategies.interfaces.IAlecMessageGeneratorStrategy;

public class AlecUnexpectedRuntimeErrorExceptionFactory
    extends AbstractAlecExceptionFactory<AlecUnexpectedRuntimeErrorException> {
    public static final AlecUnexpectedRuntimeErrorExceptionFactory PLAIN
        = new AlecUnexpectedRuntimeErrorExceptionFactory(new PlainAlecMessageGeneratorStrategy());
    public static final AlecUnexpectedRuntimeErrorExceptionFactory FORMAT
        = new AlecUnexpectedRuntimeErrorExceptionFactory(
            new FormatStringAlecMessageGeneratorStrategy()
        );
    private IAlecMessageGeneratorStrategy alecMessageGeneratorStrategy;
    private IAlecExceptionContructionStrategy<AlecUnexpectedRuntimeErrorException>
        alecExceptionContructionStrategy
        = new StandardConstructorAlecExceptionConstructionStrategy<>();

    public AlecUnexpectedRuntimeErrorExceptionFactory(
        IAlecMessageGeneratorStrategy alecMessageGeneratorStrategy
    ) {
        this.alecMessageGeneratorStrategy = alecMessageGeneratorStrategy;
    }

    public IAlecExceptionContructionStrategy<AlecUnexpectedRuntimeErrorException>
    getAlecExceptionContructionStrategy() {
        return alecExceptionContructionStrategy;
    }

    public void setAlecExceptionContructionStrategy(
        IAlecExceptionContructionStrategy<AlecUnexpectedRuntimeErrorException>
            alecExceptionContructionStrategy
    ) {
        this.alecExceptionContructionStrategy = alecExceptionContructionStrategy;
    }

    public IAlecMessageGeneratorStrategy getAlecMessageGeneratorStrategy() {
        return alecMessageGeneratorStrategy;
    }

    public void setAlecMessageGeneratorStrategy(IAlecMessageGeneratorStrategy strategy) {
        this.alecMessageGeneratorStrategy = strategy;
    }

    @Override
    public AlecUnexpectedRuntimeErrorException
    createAlecExceptionWithCause(Throwable cause, Object... args) {
        return this.alecExceptionContructionStrategy.constructAlecException(
            this.alecMessageGeneratorStrategy.generateAlecMessage(args),
            cause,
            AlecUnexpectedRuntimeErrorException.class
        );
    }
}

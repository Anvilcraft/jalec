package net.anvilcraft.alec.jalec.factories;

import net.anvilcraft.alec.jalec.exceptions.AlecCriticalRuntimeErrorException;
import net.anvilcraft.alec.jalec.strategies.implementations.AlecCriticalRuntimeErrorExceptionConstructionStrategy;
import net.anvilcraft.alec.jalec.strategies.implementations.PlainAlecMessageGeneratorStrategy;
import net.anvilcraft.alec.jalec.strategies.interfaces.IAlecExceptionContructionStrategy;
import net.anvilcraft.alec.jalec.strategies.interfaces.IAlecMessageGeneratorStrategy;

public class AlecCriticalRuntimeErrorExceptionFactory
    extends AbstractAlecExceptionFactory<AlecCriticalRuntimeErrorException> {
    public static final AlecCriticalRuntimeErrorExceptionFactory PLAIN
        = new AlecCriticalRuntimeErrorExceptionFactory(new PlainAlecMessageGeneratorStrategy());
    private IAlecMessageGeneratorStrategy alecMessageGeneratorStrategy;
    private IAlecExceptionContructionStrategy<AlecCriticalRuntimeErrorException>
        alecExceptionContructionStrategy
        = new AlecCriticalRuntimeErrorExceptionConstructionStrategy();

    public AlecCriticalRuntimeErrorExceptionFactory(
        IAlecMessageGeneratorStrategy alecMessageGeneratorStrategy
    ) {
        this.alecMessageGeneratorStrategy = alecMessageGeneratorStrategy;
    }

    @Override
    public AlecCriticalRuntimeErrorException
    createAlecExceptionWithCause(Throwable cause, Object... args) {
        return this.alecExceptionContructionStrategy.constructAlecException(
            this.alecMessageGeneratorStrategy.generateAlecMessage(args),
            cause,
            AlecCriticalRuntimeErrorException.class
        );
    }

    public IAlecMessageGeneratorStrategy getAlecMessageGeneratorStrategy() {
        return alecMessageGeneratorStrategy;
    }

    public void
    setAlecMessageGeneratorStrategy(IAlecMessageGeneratorStrategy alecMessageGeneratorStrategy) {
        this.alecMessageGeneratorStrategy = alecMessageGeneratorStrategy;
    }

    public IAlecExceptionContructionStrategy<AlecCriticalRuntimeErrorException>
    getAlecExceptionContructionStrategy() {
        return alecExceptionContructionStrategy;
    }

    public void setAlecExceptionContructionStrategy(
        IAlecExceptionContructionStrategy<AlecCriticalRuntimeErrorException>
            alecExceptionContructionStrategy
    ) {
        this.alecExceptionContructionStrategy = alecExceptionContructionStrategy;
    }
}

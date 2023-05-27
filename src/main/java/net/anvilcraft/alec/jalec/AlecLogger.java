package net.anvilcraft.alec.jalec;

import net.anvilcraft.alec.jalec.strategies.implementations.FormatStringAlecMessageGeneratorStrategy;
import net.anvilcraft.alec.jalec.strategies.implementations.PlainAlecMessageGeneratorStrategy;
import net.anvilcraft.alec.jalec.strategies.interfaces.IAlecMessageGeneratorStrategy;

public class AlecLogger {
    public static final AlecLogger FMT
        = new AlecLogger(new FormatStringAlecMessageGeneratorStrategy());

    public static final AlecLogger PLAIN = new AlecLogger(new PlainAlecMessageGeneratorStrategy());

    private final IAlecMessageGeneratorStrategy alecMessageGeneratorStrategy;

    public AlecLogger(IAlecMessageGeneratorStrategy alecMessageGeneratorStrategy) {
        this.alecMessageGeneratorStrategy = alecMessageGeneratorStrategy;
    }

    public void alec(Object... args) {
        System.out.println("ALEC: " + this.alecMessageGeneratorStrategy.generateAlecMessage(args));
    }
}

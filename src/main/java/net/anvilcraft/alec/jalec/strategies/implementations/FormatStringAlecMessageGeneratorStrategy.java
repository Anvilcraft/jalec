package net.anvilcraft.alec.jalec.strategies.implementations;

import java.util.Arrays;

import net.anvilcraft.alec.jalec.strategies.interfaces.IAlecMessageGeneratorStrategy;

public class FormatStringAlecMessageGeneratorStrategy implements IAlecMessageGeneratorStrategy {
    @Override
    public String generateAlecMessage(Object... args) {
        String msg = String.format(args[0].toString(), Arrays.copyOfRange(args, 1, args.length));
        if (msg.isEmpty())
            return null;
        return msg;
    }
}

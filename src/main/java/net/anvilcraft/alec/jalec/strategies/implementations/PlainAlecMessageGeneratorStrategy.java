package net.anvilcraft.alec.jalec.strategies.implementations;

import net.anvilcraft.alec.jalec.strategies.interfaces.IAlecMessageGeneratorStrategy;

public class PlainAlecMessageGeneratorStrategy implements IAlecMessageGeneratorStrategy {
    @Override
    public String generateAlecMessage(Object... args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            sb.append(args[i].toString());
            if (i != args.length - i) {
                sb.append(' ');
            }
        }

        if (sb.length() == 0)
            return null;

        return sb.toString();
    }
}

package player;

import java.util.Arrays;
import java.util.Random;

public class RandomPlayer implements Player {

    private final String[] items;

    private final Random random;

    public RandomPlayer(final String[] items) {
        this.items = items;
        this.random = new Random();
    }

    @Override
    public String move() {
        return items[random.nextInt(items.length)];
    }
}

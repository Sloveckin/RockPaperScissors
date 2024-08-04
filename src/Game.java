import config.Config;
import player.Player;

import java.util.Map;
import java.util.Set;

public class Game {
    private final Config config;
    private final Player player1;
    private final Player player2;

    public Game(final Config config, final Player player1, final Player player2) {
        this.config = config;
        this.player1 = player1;
        this.player2 = player2;
    }

    public int play() {
        System.out.println(config.gameName() + " " + "one-two-three!");
        final Map<String, Set<String>> map = config.mapItem();
        while (true) {
            final String move1 = player1.move();
            final String move2 = player2.move();
            System.out.println("Player1: " + move1);
            System.out.println("Player2: " + move2);


            if (map.get(move1) != null && map.get(move1).contains(move2)) {
                return 0;
            }

            if (map.get(move2) != null && map.get(move2).contains(move1)) {
                return 1;
            }
            System.out.println("Draw!");
        }
    }

}

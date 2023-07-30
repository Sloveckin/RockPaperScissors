import config.Config;
import config.ConfigReader;
import config.FileConfigReader;
import exception.ConfigException;
import player.RandomPlayer;
import player.UserPlayer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            final ConfigReader configReader = new FileConfigReader();
            final Config config = configReader.readConfig();
            final Game game = new Game(config, new UserPlayer(config.items()), new RandomPlayer(config.items()));
            final Scanner scanner = new Scanner(System.in);
            while (true) {
                final int res = game.play();
                if (res == 0) {
                    System.out.println("You win!");
                } else {
                    System.out.println("You lose :(");
                }
                if (stopOrContinue(scanner)) {
                    break;
                }
            }
        } catch (final ConfigException e) {
            System.err.println("Config exception: " + e.getMessage());
        }
    }

    private static boolean stopOrContinue(final Scanner scanner) {
        System.out.println("Do you want to continue?");
        boolean flag = false;
        while (true) {
            final String input = scanner.nextLine();
            if (input.equals("Yes")) {
                flag = false;
                break;
            } else if (input.equals("No")) {
                flag = true;
                break;
            } else {
                System.out.println("Repeat please..");
            }
        }
        return flag;
    }

}
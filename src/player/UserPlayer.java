package player;

import java.util.Scanner;

public class UserPlayer implements Player {

    private final Scanner scanner;

    private final String[] items;

    public UserPlayer(final String[] items) {
        this.items = items;
        this.scanner = new Scanner(System.in);
    }


    @Override
    public String move() {
        System.out.println("Please, make move");
        for (int i = 0; i < items.length; i++) {
            System.out.println(i + ": " + items[i]);
        }
        return getInput();
    }

    private String getInput() {
        while (true) {
            try {
                final int input = Integer.parseInt(scanner.nextLine());
                if (input < 0 || input > items.length) {
                    System.out.println("Repeat please..");
                    continue;
                }
                return items[input];
            } catch (final NumberFormatException e) {
                System.out.println("Repeat please..");
            }
        }
    }

}

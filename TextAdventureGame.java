import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextAdventureGame {
    private String playerName;
    private GameMode gameMode;
    private List<Item> inventory;

    public TextAdventureGame(String playerName) {
        this.playerName = playerName;
        this.inventory = new ArrayList<>();
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public void start() {
        System.out.println("Press P to start playing, " + playerName + ".");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        if (input.equalsIgnoreCase("P")) {
            if (gameMode != null) {
                gameMode.play(this);
            } else {
                System.out.println("Please select a game mode first.");
            }
        } else {
            System.out.println("Invalid input. Please try again.");
        }
    }

    public void explore() {
        System.out.println("You are in a dark forest. What do you want to do?");
        System.out.println("1. Search for items");
        System.out.println("2. Fight a monster");
        System.out.println("3. Check inventory");
        System.out.println("4. Exit game");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                searchForItems();
                break;
            case 2:
                fightMonster();
                break;
            case 3:
                checkInventory();
                break;
            case 4:
                System.out.println("Exiting game. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                explore();
                break;
        }
    }

    private void searchForItems() {
        System.out.println("You found a health potion!");
        Item potion = new Item("Health Potion", "Restores 20 health.");
        inventory.add(potion);
        System.out.println("You added " + potion.getName() + " to your inventory.");
        explore();
    }

    private void fightMonster() {
        System.out.println("A wild goblin appears!");
        System.out.println("You have two options: ");
        System.out.println("1. Attack");
        System.out.println("2. Run away");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("You attack the goblin and defeat it!");
        } else {
            System.out.println("You ran away safely.");
        }
        explore();
    }

    private void checkInventory() {
        System.out.println("Your inventory:");
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            for (Item item : inventory) {
                System.out.println("- " + item.getName() + ": " + item.getDescription());
            }
        }
        explore();
    }
}
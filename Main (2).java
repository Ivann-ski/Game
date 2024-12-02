import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String playerName = scanner.next();
        TextAdventureGame game = new TextAdventureGame(playerName);
        System.out.println("Press 1 or 2 to select your game mode.");
        System.out.println("1 - Story");
        System.out.println("2 - Survival");
        int mode = scanner.nextInt();
        if (mode == 1) {
            game.setGameMode(new StoryMode() {});
        } else if (mode == 2) {
            game.setGameMode(new SurvivalMode() {});
        } else {
            System.out.println("Invalid game mode. Please try again.");
            return;
        }
        game.start();
    }
}
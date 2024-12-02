public interface SurvivalMode extends GameMode {
    default void play(TextAdventureGame game) {
        System.out.println("You are playing in survival mode.");
        game.explore();
    }
}
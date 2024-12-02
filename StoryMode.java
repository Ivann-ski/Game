public interface StoryMode extends GameMode {
    default void play(TextAdventureGame game) {
        System.out.println("You are playing in story mode.");
        game.explore();
    }
}
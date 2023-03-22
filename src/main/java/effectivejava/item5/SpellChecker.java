package effectivejava.item5;

/**
 * Item 5: Prefer dependency injection to hardwiring resources
 */
public class SpellChecker {
    private final Lexicon dictionary;

    // Dependency injection provides flexibility and testability
    public SpellChecker(Lexicon dictionary){
        this.dictionary = dictionary;
    }
}

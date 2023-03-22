package effectivejava;

/**
 * Item 4: Enforce noninstantiability with a private constructor
 *
 * Noninstantiable utility class
 * As a side effect, this idiom also prevents the class from being subclassed. All
 * constructors must invoke a superclass constructor, explicitly or implicitly, and a
 * subclass would have no accessible superclass constructor to invoke.
 */
public class Item4 {

    // Suppress default constructor for noninstantiability
    private Item4(){
        throw new AssertionError();
    }
}

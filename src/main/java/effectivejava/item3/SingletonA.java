package effectivejava.item3;

import java.io.Serializable;

/**
 * Item 3: Enforce the singleton property with a private
 * constructor or an enum type
 * Nothing that a client does
 * can change this, with one caveat: a privileged client can invoke the private
 * constructor reflectively (Item 65) with the aid of the
 * AccessibleObject.setAccessible method. If you need to defend
 * against this attack, modify the constructor to make it throw an exception if it’s
 * asked to create a second instance.
 */
public class SingletonA implements Serializable {
    public static final SingletonA INSTANCE = new SingletonA();

    private SingletonA() {
        if(INSTANCE != null){
            throw new RuntimeException();
        }
    }

    /**
     * Option #2: the public member is a static factory method
     * - API makes it clear that the class is a singleton
     * - It gives you the flexibility to change your mind about whether the class is a singleton without changing its API.
     * - A method reference can be used as a supplier, for example Item::instance is a Supplier<Item3>
     */
    public static SingletonA getInstance() {
        return INSTANCE;
    }

    // readResolve method to preserve singleton property
    private Object readRevolve(){
        // Return the one true Item3 and let the garbage collector take care of the Item3 impersonator.
        return INSTANCE;
    }
}

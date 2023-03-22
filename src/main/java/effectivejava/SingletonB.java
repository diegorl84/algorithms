package effectivejava;

/**
 * Item 3: Enforce the singleton property with a private
 * One thing to remember here is, when serializing an enum, field variables are not getting serialized.
 * For example, if we serialize and deserialize the SingletonEnum class, we will lose the value of the int value field
 */
public class SingletonB {
    public static void main(String[] args) {
        SingletonBEnum singleton = SingletonBEnum.INSTANCE;
        System.out.println(singleton.getValue());
        singleton.setValue(2);
        System.out.println(singleton.getValue());
    }

}

package effectivejava.item1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Item 1: Consider static factory methods instead of constructors (Instance control)
 * Use of public static methods (static factories) instead of constructor
 */
public class Item1 {
    //Obtain instance by constructor
    public Item1() {
    }

    /**
     * 1. We can use different names
     *
     * 2. They are not required to create a new object each time they’re invoked (Instance controlled class)
     * i.e. Singleton, noninstantiable or inmmutable
     */
    public static Item1 getInstance(){
        return new Item1();
    }

    /**
     * 3. they can return an object of any subtype of their return type. Using such a static factory
     * method requires the client to refer to the returned object by interface rather than
     * implementation class, which is generally good practice
     * i.e: Collections use synchronizedList() to return instance
     */
    List<String> list = new ArrayList<>();
    List synchronizedList = Collections.synchronizedList(list);

    /**
     * The class of the returned object can vary from call to call as a function of the input parameters
     */




}

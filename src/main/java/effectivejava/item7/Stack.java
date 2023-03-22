package effectivejava.item7;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Item 7: Eliminate obsolete object references
 */
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e){
        ensureCapacity();
        elements[size++] = e;
    }

    /**
     * Memory leak here.
     * The pointer to last element is reduces but keeps the obsolete objects for size to elements.length
     * @return
     */
    public Object pop() {
        if(size == 0){
            throw new EmptyStackException();
        }
        return elements[--size];
    }

    public Object popNoLeak() {
        if(size == 0){
            throw new EmptyStackException();
        }
        Object result = elements[--size];
        elements[size] = null; //Eliminate obsolete reference
        return result;
    }

    public void ensureCapacity() {
        if(elements.length == size){
            elements = Arrays.copyOf(elements, 2 * size +1);
        }
    }
}

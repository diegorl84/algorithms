package effectivejava.Item6;

import java.util.regex.Pattern;

/**
 * Item 6: Avoid creating unnecessary objects
 * An object can always be reused if it is immutable
 * You can often avoid creating unnecessary objects by using static factory methods
 */
public class Ex1 {

    /**
     * Bad: it internally creates a Pattern instance for the regular expression and uses it only once,
     * after which it becomes eligible for garbage collection
     * @param s
     * @return
     */
    static boolean isRomanNumeral(String s){
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }

    /**
     * Explicitly compile the regular expression into a Pattern instance (which is immutable) as part of class initialization,
     * cache it, and reuse the same instance for every invocation of the isRomanNumeral
     */
    public static final Pattern ROMAN = Pattern.compile("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    static boolean isRomanNumeralOptimized(String s){
        return ROMAN.matcher(s).matches();
    }

    /**
     * Autoboxing created a new object. Each time the Long sum is operated, the long i will create a Long object
     * from i to sum. It creates 2^31 objects
     * Better to change Long sum for long sum
     */
    private static long sum() {
        long sum= 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++){
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sum());
    }
}

package effectivejava.item10;

/**
 * Item 10: Obey the general contract when overriding equals
 *
 * Reflexive: For any non-null reference value x, x.equals(x) must return true.
 *
 * Symmetric: For any non-null reference values x and y, x.equals(y) must return
 * true if and only if y.equals(x) returns true.
 *
 * Transitive: For any non-null reference values x, y, z, if x.equals(y) returns
 * true and y.equals(z) returns true, then x.equals(z) must return true.
 *
 * Consistent: For any non-null reference values x and y, multiple invocations
 * of x.equals(y) must consistently return true or consistently return false,
 * provided no information used in equals comparisons is modified.
 *
 * For any non-null reference value x, x.equals(null) must return false.
 *
 *
 * 1. Use the == operator to check if the argument is a reference to this object.
 *    If so, return true. This is just a performance optimization but one that is worth
 *    doing if the comparison is potentially expensive.
 * 2. Use the instanceof operator to check if the argument has the correct type.
 *    If not, return false.
 * 3. Cast the argument to the correct type. Because this cast was preceded by an instanceof test, it is guaranteed to succeed.
 * 4. For each “significant” field in the class, check if that field of the argument
 *    matches the corresponding field of this object.
 *    - If the type in Step 2 is an interface, you must access the argument’s fields via interface methods; if the type is a class,
 *      you may be able to access the fields directly, depending on their accessibility
 *    - For primitive fields whose type is not float or double, use the == operator for comparisons;
 *      for object reference fields, call the equals method recursively;
 *      for float fields, use the static Float.compare(float, float) method; and
 *      for double fields, use Double.compare(double, double).
 */
public class ex1 {
}

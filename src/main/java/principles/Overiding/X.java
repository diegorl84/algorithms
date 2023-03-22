package principles.Overiding;

public class X extends Y{

  /**
   * Should be at least as accessible as the parent
   *
   *
   * Error as default is lest accessible as public from parent
   * String method1(String A){
   *  return "String in Y";
   * }
   *
   * Not declare a new CHECKED exception or BRODER that de parent
   *
   * public String method1(String A) throws IOException {
   *     return "String in Y";
   * }
   *
   * Return must be same ort subtype
   *
   */

}

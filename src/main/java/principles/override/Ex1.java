package principles.override;

import java.util.Arrays;
import java.util.List;

public class Ex1 {

  public String method1(String a){
    return "String:" + a;
  }

  String method1(String a, String b){
    return "String a + b:" + a + b;
  }


  public String method1(Object obj){
    return "String object:" + obj.toString();
  }

  public int method1(Integer number){
    return 1;
  }

  public int method1(int number){
    return 2;
  }

  public String method1(List<String> number){
    return "List of strings";
  }

  /**
   *
   * Variable List<?> is same for List<String> and List<Integer>
   *   public String method1(List<Integer> number){
   *    return "List of strings";
   *   }
   *
   * */

  public static void main(String[] args) {
    Ex1 ex1 = new Ex1();

    System.out.println( ex1.method1(Arrays.asList("1")));
  }

  @Override
  public String toString() {
    return "Object";
  }
}

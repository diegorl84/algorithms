package principles.sort;

import java.util.LinkedList;

public class Ex1 {
  public static int solution(String S) {
    int result = 0;

    LinkedList<Integer> numbers = new LinkedList<>();
    for(int i = 0; i < S.length(); i++ ){
      int number = Character.getNumericValue(S.charAt(i));
      if(numbers.isEmpty() && number == 0){
        continue;
      }else{
        numbers.add(number);
      }

    }

    while(!numbers.isEmpty() && !numbers.getFirst().equals(0)){
      if(numbers.getLast().equals(1)){
        numbers.set(numbers.size()-1, 0);
      }else{
        numbers.removeLast();
      }
      result++;
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(solution("001"));
  }
}

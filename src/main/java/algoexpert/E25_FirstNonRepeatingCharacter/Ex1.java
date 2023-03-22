package algoexpert.E25_FirstNonRepeatingCharacter;

import java.util.HashMap;
import java.util.Map;

public class Ex1 {

    public static int firstNonRepeatingCharacter(String string) {
        Map<Character, Integer> counter = new HashMap<>();
        int idx = -1;
        for(int i = 0; i < string.length() ; i++){
            counter.put(string.charAt(i), counter.getOrDefault(string.charAt(i),0) + 1);
        }
        for(int i = 0; i < string.length() ; i++){
            if(counter.get(string.charAt(i)) == 1 ){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String input = "abcdcaf";
        System.out.println(firstNonRepeatingCharacter(input));

    }
}

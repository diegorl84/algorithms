package leedcode.top_interview_questions_medium.LongestSubstringWithoutRepeatingCharacters;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class Ex1 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> checker = new HashSet<>();
        int result = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            while(checker.contains(s.charAt(r))){
                checker.remove(s.charAt(l));
                l++;
            }
            checker.add(s.charAt(r));
            result = Math.max(result, r-l+1);

        }
      return result;
    }
    @Test
    public void test(){
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}

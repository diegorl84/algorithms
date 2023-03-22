package leedcode.top_interview_questions_medium.LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;

public class Ex2 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        HashSet<Character> checker = new HashSet<>();
        int maxSubstring = 0;
        int l = 0;
        int r = 0;
        int counter = 0;
        while(r < s.length() && l < s.length()){
            if(!checker.add(s.charAt(r))){
                maxSubstring = counter > maxSubstring ? counter : maxSubstring;
                while(s.charAt(l) != s.charAt(r)){
                    checker.remove(s.charAt(l));
                    l++;
                    counter--;
                }
                l++;
                counter--;
            }
            counter++;
            r++;
        }
        return counter > maxSubstring ? counter : maxSubstring;
    }
}

package leedcode.top100likedQuestions;

import org.junit.Test;

public class T_424_longestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int opt = k;
        int maxLength = -1;
        char base = s.charAt(l);
        int currentLength = 0;

        while(r < s.length()){
            if(base == s.charAt(r)){
                currentLength++;
                r++;
            }else if(opt > 0){
                currentLength++;
                r++;
                opt--;
            }else{
                l = r;
                maxLength = maxLength > currentLength ? maxLength : currentLength;
                r = l;
                base = s.charAt(l);
                currentLength = 0;
                opt = k;
            }
        }

        return maxLength > currentLength ? maxLength : currentLength;
    }

    @Test
    public void test(){
        characterReplacement("AAAB", 0);
    }
}

package leedcode.top100likedQuestions;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class T_17_LetterCombinationsOfAPhoneNumber {
    Map<Character, String> letters =Map.of(
            '2',"abc",
            '3',"def"
    );
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        String cur = "";
        backTracking(digits, result, cur, 0);
        return result;
    }

    public void backTracking(String digits, List<String> ans, String cur, int index){
        if(cur.length() == digits.length()){
            ans.add(cur);
            return;
        }else if(index >= digits.length()){
            return;
        }else{
            String digit = letters.get(digits.charAt(index));
            for(char c : digit.toCharArray()){
                backTracking(digits, ans, cur + c, index +1);
            }
        }
    }

    @Test
    public void test(){
        System.out.println(letterCombinations("23"));
    }
}

package leedcode.top100likedQuestions;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class T_14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, Comparator.comparing(String::length));
        String prefix = "";
        for(int i = 0 ; i < strs[0].length()  ; i++){
            String currentPrefix = strs[0].substring(0,i+1);
            for(int j = 0; j < strs.length ; j++){
                if(!strs[j].startsWith(currentPrefix)){
                    return prefix;
                }else if( j == strs.length -1){
                    prefix = currentPrefix;
                }
            }
        }
        return prefix;
    }

    @Test
    public void test(){
        longestCommonPrefix(new String[]{"a"});
    }
}

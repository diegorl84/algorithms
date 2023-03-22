package algoexpert.E25_FirstNonRepeatingCharacter.E26_Semordnilap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Ex1 {
    public ArrayList<ArrayList<String>> semordnilap(String[] words) {
        HashSet<String> wordSet = new HashSet<>(Arrays.asList(words));
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for(String s : words){
            String reverse = new StringBuilder(s).reverse().toString();
            if(wordSet.contains(reverse) && !reverse.equals(s)){
                ArrayList<String> res = new ArrayList<>();
                res.add(s);
                res.add(reverse);
                result.add(res);
                wordSet.remove(s);
            }
        }

        return result;
    }
}

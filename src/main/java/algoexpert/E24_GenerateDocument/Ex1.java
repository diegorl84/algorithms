package algoexpert.E24_GenerateDocument;

import java.util.HashMap;
import java.util.Map;

public class Ex1 {

    public static boolean generateDocument(String cha, String document) {
        Map<Character, Integer> freq = new HashMap<>();
        for(int i = 0; i < cha.length(); i++ ){
            freq.put(cha.charAt(i), freq.getOrDefault(cha.charAt(i),0) + 1);
        }
        for(int i = 0; i < document.length(); i++ ){
            if(freq.getOrDefault(document.charAt(i), 0) > 0){
                freq.put(document.charAt(i), freq.get(document.charAt(i)) -1);
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String characters = "aheaolabbhb";
        String document = "hello";
        System.out.println(generateDocument(characters, document));
    }
}

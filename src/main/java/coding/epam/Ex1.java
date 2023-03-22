package coding.epam;

import java.util.HashMap;
import java.util.Map;

public class Ex1 {

    public static void count(String words){
        String[] listOfWords = words.split(" ");
        Map<String, Integer> mapCounter = new HashMap<>();

        for (String word: listOfWords) {
               mapCounter.put(word, mapCounter.getOrDefault(word, 0) + 1);
        }
    }

    public static void main(String[] args) {
        count("word word data word1 word");
    }
}

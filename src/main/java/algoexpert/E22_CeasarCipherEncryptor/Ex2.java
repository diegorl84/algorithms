package algoexpert.E22_CeasarCipherEncryptor;

/**
 * Time complexity: O(n)
 * Space: O(n)
 */
public class Ex2 {
    public static String caesarCypherEncryptor(String str, int key) {
        char[] list = str.toCharArray();
        key = key % 26;
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for(int i = 0; i < list.length; i++){
            list[i] = swift(list[i], key, alphabet);
        }
        return new String(list);
    }

    public static char swift(char letter, int key, String alphabet){
        int newLetter = (alphabet.indexOf(letter) + key) % 26;
        return alphabet.charAt(newLetter);
    }

    public static void main(String[] args) {
        System.out.println("abc".indexOf("c"));
        System.out.println(caesarCypherEncryptor("abc", 3));
    }
}

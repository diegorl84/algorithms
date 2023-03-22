package algoexpert.E22_CeasarCipherEncryptor;

/**
 * Time complexity: O(n)
 * Space: O(n)
 */
public class Ex1 {
    public static String caesarCypherEncryptor(String str, int key) {
        char[] list = str.toCharArray();
        key = key % 26;
        for(int i = 0; i < list.length; i++){
            list[i] = swift(list[i], key);
        }
        return new String(list);
    }

    public static char swift(char letter, int key){
        int result = letter + key;
        if(result <= 122){
            return (char) result;
        }else{
            return (char) (96 + (result % 122));
        }
    }

    public static void main(String[] args) {
        System.out.println(caesarCypherEncryptor("abc", 3));
    }
}

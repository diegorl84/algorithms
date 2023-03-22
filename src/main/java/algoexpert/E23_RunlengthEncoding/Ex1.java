package algoexpert.E23_RunlengthEncoding;


public class Ex1 {
    public static String runLengthEncoding(String string) {
        char[] letters = string.toCharArray();
        String result = "";
        int run = 1;

        for(int i = 1; i < letters.length;i++){
            char current = string.charAt(i);
            char prev = string.charAt(i-1);

            if(current != prev || run == 9){
                result+=Integer.toString(run) + prev;
                run = 0;
            }
            run++;
        }
        result+= Integer.toString(run) + string.charAt(string.length() -1);
        return result;
    }
}

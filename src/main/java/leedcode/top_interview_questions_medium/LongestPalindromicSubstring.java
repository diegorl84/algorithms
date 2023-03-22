package leedcode.top_interview_questions_medium;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }
        String longest = "";
        for (int i = 1; i < s.length(); i++) {
            char current = s.charAt(i);
            int ldx = i-1;
            int rdx = i+1;
            int counter = 1;
            boolean even = true;

            while(ldx >= 0 && rdx <= s.length() ){
                if(s.charAt(ldx) == current && even){
                    ldx--;
                    counter++;
                    continue;
                }else if(rdx < s.length() && s.charAt(ldx) == s.charAt(rdx)){
                    counter+=2;
                    ldx--;
                    rdx++;
                }else{
                    break;
                }
                even = false;
            }
            longest = longest.length() > counter ? longest : s.substring(ldx +1,rdx);
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bbbbbbbbbbbbbbb"));
    }
}

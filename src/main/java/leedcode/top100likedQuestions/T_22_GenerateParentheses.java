package leedcode.top100likedQuestions;

import java.util.ArrayList;
import java.util.List;

public class T_22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder cur = new StringBuilder("");
        generateParenthesis(n, ans, 0, 0, cur);
        return ans;

    }
    public void generateParenthesis(int n, List<String> ans, int open, int close, StringBuilder cur) {
        if(open < n){
            if(open >= close){
                generateParenthesis(n, ans, open +1, close, cur.append("("));
                cur.deleteCharAt(cur.length() -1);
                generateParenthesis(n, ans, open, close + 1, cur.append(")"));
                cur.deleteCharAt(cur.length() -1);
            } else{

            }
        }else{
            if(close == n){
                ans.add(cur.toString());
            }else{
                generateParenthesis(n, ans, open, close +1, cur.append(")"));
                cur.deleteCharAt(cur.length() -1);
            }
        }
    }
}

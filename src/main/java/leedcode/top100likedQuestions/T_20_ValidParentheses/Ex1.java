package leedcode.top100likedQuestions.T_20_ValidParentheses;

import org.junit.Test;

import java.util.LinkedList;

public class Ex1 {
    public boolean isValid(String s) {
        LinkedList<String> stack = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            String symbol = String.valueOf(s.charAt(i));
            if(symbol.equals("}")||
                    symbol.equals(")")||
                    symbol.equals("]")){
                if(stack.isEmpty() || !stack.getLast().equals(symbol)){
                    return false;
                }
                stack.removeLast();
            }else{
                String close = symbol.equals("{") ? "}" : symbol.equals("(") ? ")" : "]";
                stack.add(close);
            }
        }
        return stack.isEmpty();
    }
    @Test
    public void test(){
        System.out.println(isValid("{[]}"));
    }
}

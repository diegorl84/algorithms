package leedcode.top100likedQuestions.T_20_ValidParentheses;

import org.junit.Test;

public class Ex2 {
    public boolean isValid(String s) {
        boolean result = false;
        int test = 0;

        int pivot = 0;
        char[] chars = s.toCharArray();
        int[] trace = new int[chars.length];

        if (chars.length % 2 == 1) {
            return false;
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ')' || chars[i] == '}' || chars[i] == ']') {
                if (pivot == 0) {
                    return false;
                }
                if (chars[i] == ')') {
                    test = trace[--pivot] - 1;
                } else if (chars[i] == '}') {
                    test = trace[--pivot] - 2;
                } else if (chars[i] == ']') {
                    test = trace[--pivot] - 3;
                }
                if (test != 0) {
                    return false;
                }
                trace[pivot] = 0;
            } else {
                if (chars[i] == '(') {
                    trace[pivot] = 1;
                } else if (chars[i] == '{') {
                    trace[pivot] = 2;
                } else if (chars[i] == '[') {
                    trace[pivot] = 3;
                }
                if (pivot > (chars.length / 2)) {
                    return false;
                }
                pivot++;

            }

        }
        if (pivot != 0) {
            return false;
        }

        return true;
    }

    @Test
    public void test() {
        System.out.println(isValid("{[}]"));
    }
}

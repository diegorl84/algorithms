package hackerrank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time complexity = 0(1)
 * space complexity = O(n)
 */
public class RotateLeft {
//    StringBuilder
    public static List<Integer> rotLeft(List<Integer> a, int d) {
        int pos = d % a.size();
        System.out.println(pos);
        if(pos == 0){
            return a;
        }
        List<Integer> left = new ArrayList<>(a.subList(pos, a.size()));
        List<Integer> right = new ArrayList<>(a.subList(0, pos));
        left.addAll(right);
        return left;
    }
    @Test
    public void test(){
        List<Integer> i = Arrays.asList(1,2,3,4,5);
        System.out.println( rotLeft(i, 1).toString());

    }
}

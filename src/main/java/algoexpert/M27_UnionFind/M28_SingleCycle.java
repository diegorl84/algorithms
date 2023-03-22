package algoexpert.M27_UnionFind;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class M28_SingleCycle {
    public static boolean hasSingleCycle(int[] array) {
        Set<Integer> tracer = new HashSet<>();

        int i = 0;
        int n = array.length;
        int start = 0;
        boolean first = true;
        while(tracer.size() < array.length){
            if(tracer.add(i)){
                i = (i + array[i]) % n;
                i = i >= 0 ? i : i + n;
                System.out.println(i);
            }else{
                return false;
            }
        }

        return i == 0;
    }
    @Test
    public void test(){
        hasSingleCycle(new int[]{1,-1,1,-1});
    }
}

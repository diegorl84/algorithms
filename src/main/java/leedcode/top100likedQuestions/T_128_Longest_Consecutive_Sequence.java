package leedcode.top100likedQuestions;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class T_128_Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
        int[] visited = new int[nums.length];
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        Iterator<Integer> i = numSet.iterator();

        int maxSize = 0;
        while (i.hasNext()){
            Integer num = i.next();
            int currentSize = 0;
            if(!numSet.contains(num - 1)){
                currentSize++;
                while(numSet.contains(++num)){
                    currentSize++;
                }
                maxSize = maxSize > currentSize ? maxSize : currentSize;
            }
        }
        return maxSize;

    }


    @Test
    public void test(){
        int[] nums = new int[]{100,4,200,1,3,2};

        longestConsecutive(nums);



    }
}

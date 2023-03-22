package leedcode.top100likedQuestions;

import org.junit.Test;

import java.util.HashMap;

public class T_1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> list = new HashMap<>();
        for(int i = 0; i < nums.length; i++){

            if(list.containsKey(nums[i])){
                return new int[]{list.get(nums[i]), i};
            }else{
                int pair = target - nums[i];
                list.put(pair,i);
            }
        }
        return new int[0];
    }
    @Test
    public void test(){
        int[] test = {2,7,11,15};
        System.out.println(twoSum(test, 9));
    }
}

package leedcode.top_interview_questions_medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triples = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int current = nums[i];
                int l = i + 1;
                int r = nums.length - 1;
                while (l < r) {
                    int sum = current + nums[l] + nums[r];
                    if (sum > 0) {
                        r--;
                    } else if (sum < 0) {
                        l++;
                    } else if (sum == 0) {
                        triples.add(Arrays.asList(current, nums[l], nums[r]));
                        while(l < r && nums[l] == nums[l+1]) l++;
                        while(l < r && nums[r] == nums[r-1]) r--;
                        l++;
                        r--;
                    }

                }
            }
        }
        return triples;
    }

    public static void main(String[] args) {
        threeSum(new int[]{-1,0,1,2,-1,-4}).forEach(l -> System.out.println(l.toString()));
    }
}

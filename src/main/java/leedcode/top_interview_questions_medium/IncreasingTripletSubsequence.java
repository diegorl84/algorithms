package leedcode.top_interview_questions_medium;

public class IncreasingTripletSubsequence {
    public static boolean increasingTriplet(int[] nums) {
        if(nums.length < 3){
            return false;
        }
        for (int i = 1; i < nums.length; i++) {
            if(i+1 < nums.length && nums[i-1] < nums[i] && nums[i] < nums[i+1]){
                return true;
            }

        }
        return false;
    }
}

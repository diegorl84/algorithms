package leedcode.top100likedQuestions;

import org.junit.Test;

public class T_34_FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        return searchRange(nums, target, 0, nums.length -1 );
    }
    public int[] searchRange(int[] nums, int target, int l, int r) {
        int m = (l + r) / 2;
        while(r >= l){
            if(nums[m] == target){
                return checkNeighbors(nums,target,m);
            }else if(target < nums[m] ){
                return searchRange(nums, target, l, m -1 );
            }else{
                return searchRange(nums, target, m + 1 , r );

            }
        }
        return new int[]{-1,-1};
    }

    public int[] checkNeighbors(int[] nums, int target, int idx){
        int[] ans = new int[]{idx, idx};
        while(ans[0] - 1 >= 0 && nums[ans[0] -1] == target){
            ans[0]-=1;
        }
        while(ans[1] +1 < nums.length && nums[ans[1] +1] == target){
            ans[1]+=1;
        }
        return ans;
    }

    @Test
    public void test1(){
        searchRange(new int[]{5,7,7,8,8,10}, 8);
    }
    @Test
    public void test2(){
        searchRange(new int[]{1,3}, 1);
    }
}

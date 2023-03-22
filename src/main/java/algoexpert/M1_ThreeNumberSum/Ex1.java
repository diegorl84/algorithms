package algoexpert.M1_ThreeNumberSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Time complexity: O(n^2)
 * Space: O(n)
 */
public class Ex1 {
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        List<Integer[]> result = new ArrayList<>();
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++){
            int left = i+1;
            int right = array.length -1;
            while(left < right){
                int currentSum = array[i] + (array[left] + array[right]);
                if( currentSum == targetSum ){
                    result.add(new Integer[]{array[i],array[left], array[right]});
                    left++;
                    right--;
                }else if(currentSum < targetSum){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer[]> output = threeNumberSum(new int[] {12, 3, 1, 2, -6, 5, -8, 6}, 0);
        System.out.println(output);
    }
}

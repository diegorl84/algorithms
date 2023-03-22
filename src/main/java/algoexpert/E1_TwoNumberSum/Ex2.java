package algoexpert.E1_TwoNumberSum;

import java.util.Arrays;

/**
 * Time Complexity: O(nLog(n)) for Arrays.principles.sort(array) which uses a version of QuickSort
 * Space complexity: O(1), no extra space
 */
public class Ex2 {
    public static int[] twoNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        int left = 0;
        int right = array.length -1;
        while(left < right) {
            int sum = array[left] + array[right];
            if(sum == targetSum){
                return new int[]{ array[left], array[right]};
            }else if(sum < targetSum){
                left++;
            }else if (sum > targetSum){
                right--;
            }
        }

        return new int[0];
    }
    public static void main(String[] args) {
        int[] test = {3, 5, -4, 8, 11, 1, -1, 6};
        int[] result = twoNumberSum(test, 10);
        Arrays.stream(result).forEach(System.out::println);
    }
}

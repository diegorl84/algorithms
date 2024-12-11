package algoexpert.E1_TwoNumberSum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * Time complexity: O(N)
     * Only travers once
     * Accessing value in hash table is O(1)
     * Space complexity: O(N)
     */
    public static int[] twoNumberSum(int[] array, int targetSum) {
        Set<Integer> nums = new HashSet<>();

        for (int i = 0; i < array.length + 1; i++) {
            int product = targetSum - array[i];
            if (nums.contains(product)) {
                return new int[]{array[i], product};
            } else {
                nums.add(array[i]);
            }
        }
        return new int[0];
    }

    /**
     * Time complexity: O(n log n)
     * Arrays.sort uses quick sort, O(n log n)
     * Space complexity: O(1)
     */
    public static int[] twoNumberSum2(int[] array, int targetSum) {

        Arrays.sort(array);
        int l = 0;
        int r = array.length - 1;

        while (l < r) {
            int product = array[l] + array[r];
            if (product == targetSum) {
                return new int[]{array[l], array[r]};
            } else if (product > targetSum) {
                r--;
            } else {
                l++;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
//        int[] test = {3, 5, -4, 8, 11, 1, -1, 6};
        int[] test = {11, -1};
        Arrays.stream(twoNumberSum2(test, 10)).forEach(System.out::println);
    }
}

package algoexpert.E1_TwoNumberSum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Time Complexity: O(n)
 * Space complexity: O(n) for the set. In the worse case it will use same space as array
 */
public class Ex1 {

    public static int[] twoNumberSum(int[] array, int targetSum) {
        Set<Integer> nums = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            int temp = targetSum - array[i];
            if (nums.contains(temp)) {
                return new int[]{array[i], temp};
            } else {
                nums.add(array[i]);
               // System.out.println(nums);
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] test = {3, 5, -4, 8, 11, 1, -1, 6};
        Arrays.stream(twoNumberSum(test, 10)).forEach(System.out::println);
        TypeEnum r = TypeEnum.valueOf("CconstructItem(original, latestCategory, facv3be)");
        System.out.println(r);

    }
}

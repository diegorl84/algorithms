package algoexpert.E17_FindThreeLargeNumbers;

/**
 * Time complexity: O(n*2)
 */
public class Ex1 {
    public static int[] findThreeLargestNumbers(int[] array) {
        int[] result = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int i = 0; i < array.length; i++) {
            if (array[i] > result[0]) {
                result[0] = array[i];
                sortResult(result);
            }
        }
        return result;
    }

    public static void sortResult(int[] result) {
        for (int i = 0; i < result.length - 1; i++) {
            if (result[i] > result[i + 1]) {
                int temp = result[i + 1];
                result[i + 1] = result[i];
                result[i] = temp;
            }
        }
    }
}

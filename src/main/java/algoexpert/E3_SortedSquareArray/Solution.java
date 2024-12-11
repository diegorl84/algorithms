package algoexpert.E3_SortedSquareArray;

import java.util.Arrays;

public class Solution {

    /**
     * Time complexity: O(n log n)
     * Space complexity: O(n)
     */
    public static int[] sortedSquaredArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * array[i];
        }
        Arrays.sort(array);
        return array;
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public static int[] sortedSquaredArray2(int[] array) {
        int[] sortedSquares = new int[array.length];
        int smallValueIdx = 0;
        int largerValueIdx = array.length - 1;

        for (int i = array.length - 1; i >= 0; i--) {
            int smallValue = array[smallValueIdx];
            int largeValue = array[largerValueIdx];

            if (Math.abs(smallValue) > Math.abs(largeValue)) {
                sortedSquares[i] = smallValue * smallValue;
                smallValueIdx++;
            } else {
                sortedSquares[i] = largeValue * largeValue;
                largerValueIdx--;
            }
        }
        return sortedSquares;
    }

    public static void main(String[] args) {
        sortedSquaredArray(new int[]{-3, -2, -1, 1, 2, 3});
    }
}

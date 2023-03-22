package algoexpert.E3_SortedSquareArray;

/**
 * Time Complexity: O(n)
 * Space complexity: O(n)
 * {-3,-2,-1,1,2,3}
 */
public class Ex2 {

    static public int[] sortedSquaredArray(int[] array) {
        int[] sortedSquares = new int[array.length];
        int smallerValueIdx = 0;
        int largerValueIdx = array.length - 1;

        for (int i = array.length - 1; i >= 0; i--) {
            int smallerValue = array[smallerValueIdx];
            int largerValue = array[largerValueIdx];
            if (Math.abs(smallerValue) > Math.abs(largerValue)) {
                sortedSquares[i] = smallerValue * smallerValue;
                smallerValueIdx++;
            } else {
                sortedSquares[i] = largerValue * largerValue;
                largerValueIdx--;
            }
        }

        return sortedSquares;
    }

    public static void main(String[] args) {
        sortedSquaredArray(new int[]{-3, -2, -1, 1, 2, 3});
    }
}

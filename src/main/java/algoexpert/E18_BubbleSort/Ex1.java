package algoexpert.E18_BubbleSort;

/**
 * Time complexity:
 *      - Worse O(n^2)
 *      - Average O(n^2)
 * Space: O(1)
 */
public class Ex1 {

    public static int[] bubbleSort(int[] array) {
        int r = array.length - 1;
        while (r > 0) {
            for (int i = 0; i < r; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            r--;
        }

        return array;
    }
}

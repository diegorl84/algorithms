package algoexpert.E3_SortedSquareArray;

import java.util.Arrays;
/**
 * Time Complexity: O(nLog(n)) for quicksort principles.sort
 * Space complexity: O(1) no extra space
 */
public class Ex1 {
    public int[] sortedSquaredArray(int[] array) {
        for(int i = 0; i < array.length; i++){
            array[i] = array[i]* array[i];
        }
        Arrays.sort(array);
        return array;
    }
}

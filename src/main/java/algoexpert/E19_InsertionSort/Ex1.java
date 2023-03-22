package algoexpert.E19_InsertionSort;

/**
 * Time complexity:
 *      - Worse O(n^2)
 *      - Average O(n^2)
 * Space: O(1)
 */
public class Ex1 {

    public static int[] bubbleSort(int[] array) {
        if(array.length == 0){
            return new int[]{};
        }
        for(int i = 1; i < array.length; i++){
            int j = i;
            while(j > 0 && array[j] < array[j -1]){
                int temp = array[j-1];
                array[j-1] = array[j];
                array[j] = temp;
                j = j -1;
            }
        }
        return array;
    }
}

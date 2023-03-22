package algoexpert.E16_BinarySearch;

/**
 * Time complexity: O(log n). Every iteration half of the options are reduced
 * Space: O(log n)
 */
public class Ex1 {

    public static int binarySearch(int[] array, int target) {
        return binarySearch(array, target, 0, array.length -1 );
    }
    public static int binarySearch(int[] array, int target, int r, int l) {
        if(l > r){
            return  -1;
        }
        int middle = (r + l) / 2;
        if(array[middle] == target){
            return middle;
        }else if(target < array[middle]){
            return binarySearch(array, target, l, middle -1);
        }else{
            return binarySearch(array, target, middle + 1, r);
        }
    }
}

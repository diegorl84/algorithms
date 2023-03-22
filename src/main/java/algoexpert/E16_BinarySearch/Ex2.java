package algoexpert.E16_BinarySearch;

/**
 * Time complexity: O(n log(n))
 * Space: O(1)
 */
public class Ex2 {

    public static int binarySearch(int[] array, int target) {
        return binarySearch(array, target, 0, array.length -1 );
    }
    public static int binarySearch(int[] array, int target, int r, int l) {
       while(l <= r){
           int middle = (l+ r) / 2;
           if(target == array[middle]){
               return middle;
           }else if(target < array[middle]) {
               r = middle - 1;
           }else{
               l = middle + 1;
           }
       }
       return -1;
    }
}

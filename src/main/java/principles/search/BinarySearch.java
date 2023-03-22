package principles.search;

import org.junit.Test;

/**
 * Time Complexity : O(Log n) Auxiliary Space : The above implementation of Binary Search is
 * recursive and requires O(Log n) space. With iterative Binary Search, we need only O(1) space.
 * Applications of Exponential Search:
 *
 * <p>Exponential Binary Search is particularly useful for unbounded searches, where size of array
 * is infinite. Please refer Unbounded Binary Search for an example. It works better than Binary
 * Search for bounded arrays, and also when the element to be searched is closer to the first
 * element.
 */
public class BinarySearch {

  public static int search(int arr[], int target) {
    int l = 0;
    int r = arr.length -1;
    return search(arr, l, r, target);
  }
  public static int search(int[] arr, int l, int r, int target) {

    if (r >= l) {
      int mid = l + (r - l) / 2;

      if (arr[mid] == target) {
        return mid;
      }

      if (arr[mid] > target) {
        return search(arr, l, mid - 1, target);
      } else {
        return search(arr, mid + 1, r, target);
      }
    }

    return -1;
  }
  @Test
  public void test(){
    int arr[] = {2, 3, 4, 10, 40, 50, 100, 101, 105, 107, 200, 1000, 1002, 1003, 1010, 1020, 1030};
    System.out.println(search(arr, 1002));
  }
}

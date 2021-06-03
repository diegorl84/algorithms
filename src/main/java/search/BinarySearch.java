package search;

import java.util.Arrays;

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

  public static int search(int arr[], int l, int r, int x) {

    if (r >= l) {
      int mid = l + (r - l) / 2;

      if (arr[mid] == x) {
        return mid;
      }

      if (arr[mid] > x) {
        return search(arr, l, mid - 1, x);
      } else {
        return search(arr, mid + 1, r, x);
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    BinarySearch ob = new BinarySearch();
    int arr[] = {2, 3, 4, 10, 40, 50, 100, 101, 105, 107, 200, 1000, 1002, 1003, 1010, 1020, 1030};
    int x = 1002;
    int result = ob.search(arr, 0, arr.length - 1, x);
    System.out.println(result);
  }
}

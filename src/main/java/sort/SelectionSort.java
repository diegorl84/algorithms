package sort;

/**
 * The selection sort algorithm sorts an array by repeatedly finding the minimum element
 * (considering ascending order) from unsorted part and putting it at the beginning. The algorithm
 * maintains two subarrays in a given array.
 * Time Complexity: O(n^2) as there are two nested loops.
 * The good thing about selection sort is it never makes more than O(n) swaps and can be useful when memory write is a costly operation.
 */
public class SelectionSort extends Sort{

  public static void main(String[] args) {
    SelectionSort selectionSort = new SelectionSort();
    selectionSort.sort(selectionSort.arr);
    selectionSort.printArray(selectionSort.arr);
  }

  public void sort(int[] arr) {
    int n = arr.length;

    for (int i = 0; i < n; i++) {
      int min_idx = i;
      for (int j = i + 1; j < n; j++) {
        if (arr[j] < arr[min_idx]) {
          min_idx = j;
        }
      }

      int temp = arr[min_idx];
      arr[min_idx] = arr[i];
      arr[i] = temp;
    }
  }
}

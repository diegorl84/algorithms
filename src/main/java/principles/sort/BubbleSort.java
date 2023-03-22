package principles.sort;

/**
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent
 * elements if they are in wrong order.
 * Worst and Average Case Time Complexity: O(n*n). Worst case occurs when array is reverse sorted
 */
public class BubbleSort extends Sort {
  public void sort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
  }

  public static void main(String[] args) {
    BubbleSort bubbleSort = new BubbleSort();
    bubbleSort.sort(ARR);
  }
}

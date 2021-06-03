package sort;

/**
 * Heap sort is a comparison-based sorting technique based on Binary Heap data structure. It is
 * similar to selection sort where we first find the minimum element and place the minimum element
 * at the beginning. We repeat the same process for the remaining elements Binary Heap: Complete
 * Binary Tree ordered
 */
public class HeapSort extends Sort {

  @Override
  public void sort(int[] arr) {
    int n = arr.length;

    for (int i = n / 2 - 1; i >= 0; i--) {
      heapfy(arr, n, i);
    }
  }

  /**
   * @param arr
   * @param n Size
   * @param i Node (index)
   */
  void heapfy(int arr[], int n, int i) {
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;

    if (l < n && arr[l] > arr[largest]) {
      largest = l;
    }

    if (r < n && arr[r] > arr[largest]) {
      largest = r;
    }

    if (largest != i) {
      int swap = arr[i];
      arr[i] = arr[largest];
      arr[largest] = swap;
      heapfy(arr, n, largest);
    }
  }

  public static void main(String[] args) {
    int n = arr.length;
    HeapSort heapSort = new HeapSort();
    heapSort.sort(arr);

    heapSort.printArray(arr);
  }
}

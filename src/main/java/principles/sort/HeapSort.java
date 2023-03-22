package principles.sort;

/**
 * Heap principles.sort is a comparison-based sorting technique based on Binary Heap data structure. It is
 * similar to selection principles.sort where we first find the minimum element and place the minimum element
 * at the beginning. We repeat the same process for the remaining elements Binary Heap: Complete
 * Binary Tree ordered
 *
 * Time Complexity: Time complexity of heapify is O(Logn).
 * Time complexity of createAndBuildHeap() is O(n) and the overall time complexity of Heap Sort is O(nLogn).
 *
 */
public class HeapSort extends Sort {

  @Override
  public void sort(int[] arr) {
    int n = arr.length;

    for (int i = n / 2 - 1; i >= 0; i--) {
      heapfy(arr, n, i);
    }

    for (int i = n - 1; i > 0; i--) {
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;
      heapfy(arr, i, 0);
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
    int n = ARR.length;
    HeapSort heapSort = new HeapSort();
    heapSort.sort(ARR);

    heapSort.printArray(ARR);
  }
}

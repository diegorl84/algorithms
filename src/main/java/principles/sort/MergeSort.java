package principles.sort;

import java.util.Arrays;

/**
 * Divide and conquer.
 * Divide the array into to parts. Call itself to divide again (recursion), principles.sort the smallest arrays and then merge.
 * Time complexity of Merge Sort is  θ(nLogn)
 */
public class MergeSort {

  public void merge(int[] arr, int start, int middle, int end) {

    int n1 = middle - start + 1;
    int n2 = end - middle;

    int L[] = new int[n1];
    int R[] = new int[n2];

    /*Copy data to temp arrays*/
    for (int i = 0; i < n1; ++i) L[i] = arr[start + i];
    for (int j = 0; j < n2; ++j) R[j] = arr[middle + 1 + j];

    int i = 0, j = 0;
    int k = start;

    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        arr[k] = L[i];
        i++;
      } else {
        arr[k] = R[j];
        j++;
      }
      k++;
    }

    while (i < n1) {
      arr[k] = L[i];
      i++;
      k++;
    }

    while (j < n2) {
      arr[k] = R[j];
      j++;
      k++;
    }
  }

  public void sort(int[] A, int start, int end) {
    if (start < end) {
      int mid = (start + end) / 2;
      sort(A, start, mid);
      sort(A, mid + 1, end);
      merge(A, start, mid, end);
    }
  }

  public static void main(String[] args) {
    int in[] = {9, 7, 8, 3, 2, 1};
    MergeSort mergeSort = new MergeSort();
    mergeSort.sort(in, 0, in.length - 1);
      System.out.println(Arrays.toString(in));
    // printArray(in);
  }
}

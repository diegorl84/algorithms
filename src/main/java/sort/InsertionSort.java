package sort;

/**
 * Like organizing card in a hand
 * Time Complexity: O(n^2)
 * Auxiliary Space: O(1)
 * Uses: Insertion sort is used when number of elements is small.
 * It can also be useful when input array is almost sorted, only few elements are misplaced in complete big array.
 *
 * Binary Insertion Sort?
 * Reduce the number of comparisons in normal insertion sort.
 * Binary Insertion Sort uses binary search to find the proper location to insert the selected item at each iteration.
 * In normal insertion, sorting takes O(i) (at ith iteration) in worst case. We can reduce it to O(logi) by using binary search.
 */
public class InsertionSort extends Sort{

  public void sort(int[] a) {
    for (int j = 1; j < a.length ; j++){
      int key = a[j];
      int i = j-1;
      while(i >= 0 && a[i] > key){
        a[i+1] = a[i];
        i--;
      }
      a[i+1] = key;
    }
  }

  public static void main(String[] args) {
    InsertionSort insertion = new InsertionSort();
    insertion.sort(arr);
    insertion.printArray(arr);
  }
}

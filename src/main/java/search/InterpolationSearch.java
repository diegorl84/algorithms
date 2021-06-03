package search;

/**
 * interpolation search may go to different locations according to the value of the key being searched.
 * For example, if the value of the key is closer to the last element, interpolation search is likely to start search toward the end side.
 *
 *The idea of formula is to return higher value of pos
 * when element to be searched is closer to arr[hi]. And smaller value when closer to arr[lo]
 * pos = lo + [ (x-arr[lo])*(hi-lo) / (arr[hi]-arr[Lo]) ]
 * arr[] ==> Array where elements need to be searched
 * x     ==> Element to be searched
 * lo    ==> Starting index in arr[]
 * hi    ==> Ending index in arr[]
 */

public class InterpolationSearch {

  public static int search(int[] arr, int lo, int hi, int x) {
    int pos;
    if (lo <= hi && x >= arr[lo] && x <= arr[hi]) {
      pos = lo + ((x-arr[lo])*(hi-lo) / (arr[hi]-arr[lo]) );

      if (arr[pos] == x) {
        return pos;
      }

      if (arr[pos] < x) {
        return search(arr, pos + 1, hi, x);
      }

      if (arr[pos] > x) {
        return search(arr, lo, pos - 1, x);
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = {10, 12, 13, 16, 18, 19, 20, 21, 22, 23, 24, 33, 35, 42, 47};
    int n = arr.length;

    int x = 35;
    int index = search(arr, 0, n - 1, x);

    System.out.println(index);
  }
}

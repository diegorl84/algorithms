package principles.search;

public class ExponentialSearch {

  public static int search(int arr[], int n, int x) {
    if (arr[0] == x) {
      return 0;
    }
    int i = 1;
    while (i < n && arr[i] <= x) {
      i = i * 2;
    }
    return BinarySearch.search(arr, x);
  }

  public static void main(String[] args) {
    int arr[] = {2, 3, 4, 10, 40,50,100,101,105,107,200,1000,1002,1003,1010,1020,1030};
    int x = 1002;
    int result = search(arr, arr.length, x);
    System.out.println((result < 0) ? "Element is not present in array" : "Element in " + result);
  }
}

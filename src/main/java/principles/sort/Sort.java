package principles.sort;

public abstract class Sort {

  public static int[] ARR = {4,-2, -3, -1, 3, 2, 1, 0, -4};
//  public static int[] ARR = {4,-2, -3, -1, 3, 2, 1, 0, -4,6,-6,5,-5,7,-7,8};
  public abstract void sort(int[] a);

  public void printArray(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; ++i) System.out.print(arr[i] + " ");

    System.out.println();
  }
}

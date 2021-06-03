package sort;

public abstract class Sort {

  public static int[] arr = {64, 25, 12, 11, 10, 100, 50, 20, 28};
  public abstract void sort(int[] a);

  public void printArray(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; ++i) System.out.print(arr[i] + " ");

    System.out.println();
  }
}

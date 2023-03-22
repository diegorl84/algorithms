package principles.search;

public class FibonacciSearch {

  public static int min(int x, int y) {
    return (x <= y) ? x : y;
  }

  public static int search(int[] arr, int x, int n) {

    int fib1 = 0; // Fibonacci m-2
    int fib2 = 1; // Fibonacci m-1
    int fibM = fib1 + fib2; // Fibonacci m

    while (fibM < n) {
      fib2 = fib1;
      fib1 = fibM;
      fibM = fib2 + fib1;
    }
    int offset = -1;

    while (fibM > 1) {
      int i = min(offset + fib2, n - 1);

      if (arr[i] < x) {
        fibM = fib1;
        fib1 = fib2;
        fib2 = fibM - fib1;
        offset = i;
      } else if (arr[i] > x) {
        fibM = fib2;
        fib1 = fib1 + fib2;
        fib2 = fibM - fib1;
      } else {
        return i;
      }
    }
    if (fib1 == 1 && arr[n - 1] == x) {
      return n - 1;
    }
    return -1;
  }

  public static void main(String[] args) {
    int arr[] = { 10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100,235};
    int n = 12;
    int x = 235;

    int ind = search(arr, x, n);
    if(ind>=0)
      System.out.print("Found at index: "+ind);
    else
      System.out.print(x+" isn't present in the array");
  }
}

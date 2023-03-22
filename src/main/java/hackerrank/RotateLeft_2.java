package hackerrank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Time complexity = 0(1)
 * space complexity = O(n)
 */
public class RotateLeft_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n =5;
        int k = 2;
        int a[] = new int[]{1,2,3,4,5};

        int[] output = new int[n];
        if ((a.length == 1) || (k == a.length)) output = a;
        else output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");

        System.out.println();

    }

    public static int[] arrayLeftRotation(int[] a, int n, int k){
        int[] oa = new int[n];
        int ni = n-1-k;
        for(int i=n-1; i>=0; i--){
            if(ni == -1) ni = n-1;
            oa[ni] = a[i];
            ni--;
        }
        return oa;
    }

}

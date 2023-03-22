package algoexpert.M7_ArrayOfProducts;

import java.util.Arrays;

public class Ex1 {
    public static int[] arrayOfProducts(int[] array) {
        int[] leftArray = new int[array.length];
        int[] rightArray = new int[array.length];
        int[] result = new int[array.length];
        leftArray[0]=1;
        for(int i = 1; i < array.length; i++){
            leftArray[i] = leftArray[i-1] * array[i-1];
        }

        int pos = array.length - 1;
        rightArray[pos] = 1;
        for(int i = pos - 1; i >= 0; i--){
            rightArray[i] = rightArray[i+1] * array[i + 1];
        }

        for(int i = 0; i < array.length; i++){
            result[i] = rightArray[i] * leftArray[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{5,1,4,2};
        Arrays.stream(arrayOfProducts(array)).forEach(System.out::println);
    }
}

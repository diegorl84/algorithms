package algoexpert.M8_FirstDuplicateValue;

public class Ex2 {
    public static int firstDuplicateValue(int[] array) {
        for (int value : array){
            int absValue = Math.abs(value);
            if(array[absValue - 1 ] < 0){
                return absValue;
            }
            array[absValue -1] *= -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstDuplicateValue(new int[]{2,1,5,2,3,3,4}));
    }
}

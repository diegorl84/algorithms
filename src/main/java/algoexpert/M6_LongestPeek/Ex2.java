package algoexpert.M6_LongestPeek;

/**
 * Time complexity:
 */
public class Ex2 {
    public static int longestPeak(int[] array) {
        if(array.length < 2){
            return 0;
        }
        int longestPeekLength = 0;
        for(int i = 1; i < array.length - 1; i++){
            if(array[i-1] < array[i] && array[i] > array[i+1]){
                int currentLength = calculateLength(array, i);
                longestPeekLength = longestPeekLength > currentLength ? longestPeekLength : currentLength;
            }
        }
        return longestPeekLength;
    }

    public static int calculateLength(int[] array, int i){
        int length = 3;

        int left = i - 2;
        while(left >= 0){
            if(array[left] < array[left + 1]){
                length++;
                left--;
            }else{
                break;
            }
        }
        int right = i + 2;
        while(right < array.length){
            if(array[right-1] > array[right]){
                length++;
                right++;
            }else{
                break;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        var input = new int[]{1,2,3,4,5,6,2,0};
        System.out.println(longestPeak(input));
    }
}

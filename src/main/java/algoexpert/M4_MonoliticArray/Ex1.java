package algoexpert.M4_MonoliticArray;

public class Ex1 {
    public static boolean isMonotonic(int[] array) {
        if(array.length <3){
            return true;
        }
        boolean asc = true;
        int idx =1;
        while(idx < array.length){
            if(array[idx-1] != array[idx] ){
                if(array[idx-1] > array[idx]){
                    asc = false;
                }
                idx++;
                break;
            }
            idx++;
        }

        for(int i = idx; i< array.length ; i++){
            if(asc){
                if(array[i-1] > array[i]){
                    return false;
                }
            }else{
                if(array[i-1] < array[i]){
                    return false;
                }
            }
        }
        return true;
    }
}

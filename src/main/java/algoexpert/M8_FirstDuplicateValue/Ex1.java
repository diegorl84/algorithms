package algoexpert.M8_FirstDuplicateValue;

import java.util.HashSet;

public class Ex1 {
    /**
     * O(n) time complexity
     * O(n) spoace complexity
     * @param array
     * @return
     */
    public int firstDuplicateValue(int[] array) {
        HashSet<Integer> mapList = new HashSet<>();
        for(int i = 0; i< array.length ; i++){
            if(mapList.contains(array[i])){
                return array[i];
            }else{
                mapList.add(array[i]);
            }
        }
        return -1;
    }
}

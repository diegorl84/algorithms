package algoexpert.M3_MoveElementToEnd;

import java.util.List;

public class Ex1 {
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int l = 0;
        int r = array.size() -1;

        while(l < r){
            while(l < r && array.get(r) == toMove){
                r--;
            }
            if(array.get(l) == toMove){
                int temp = array.get(r);
                array.set(r, array.get(l));
                array.set(l, temp);
            }
            l++;
        }
        return array;
    }
}

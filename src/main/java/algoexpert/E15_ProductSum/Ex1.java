package algoexpert.E15_ProductSum;

import java.util.ArrayList;
import java.util.List;

public class Ex1 {

    public static int productSum(List<Object> array) {
        int depth = 0;
       return productSum(array, depth);
    }

    public static int productSum(List<Object> array, int depth) {
        int result = 0;
        int currentDepth = depth + 1;
        for(Object object : array){
            if(object instanceof ArrayList){
                result+= productSum((List<Object>) object, currentDepth );
            }else{
                result = result + (int) object;
            }
        }
        return currentDepth * result;
    }

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        List<Object> list2 = new ArrayList<>();
        list2.add(7);
        list2.add(-1);
        list.add(list2);
        list.add(3);
        List<Object> list3 = new ArrayList<>();
        list3.add(6);
        List<Object> list4 = new ArrayList<>();
        list4.add(-13);
        list4.add(8);
        list3.add(list4);
        list3.add(4);
        list.add(list3);
        System.out.println(productSum(list));
        //12

    }
}

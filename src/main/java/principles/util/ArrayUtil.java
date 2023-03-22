package principles.util;

import java.util.Arrays;

public class ArrayUtil {
    //Generics does not accept primitives
    public static <T> void traverse2DArray( T[][] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    public static void traversePrimitive2DArray( int[][] array){

        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }
}

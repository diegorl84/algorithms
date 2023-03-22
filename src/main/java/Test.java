/**
 * Ex:
 * "1, 2, 3" -> [1, 2, 3]
 * "2-6" -> [2, 3, 4, 5, 6]
 * "1, 3-5, 9" -> [1, 3, 4, 5, 9]
 *
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 1,2-5,9
 * String[] {1,2-5,9} Inget
 * for
 * s contains -, split String[2]= 2,5
 * for 2, 5 = 2,3,4,5
 *
 */
public class Test {
    private static final String INTERNAL = "-";
    private static final String EXTERNAL = ",";
    public static List<Integer> convertString(String s){
        String[] pos = s.split(EXTERNAL);
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < pos.length; i++) {
            if(pos[i].indexOf("-") == -1){
                ans.add(Integer.valueOf(pos[i]));
            }else{
                String[] internal = pos[i].split(INTERNAL);
                int start = Integer.valueOf(internal[0]);
                int finish = Integer.valueOf(internal[1]);
                for (int j = start; j <= finish; j++ ){
                    ans.add(j);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String test = "1-1000000000000000000000";
        convertString(test).forEach(System.out::println);

    }
}

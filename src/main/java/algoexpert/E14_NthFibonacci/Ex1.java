package algoexpert.E14_NthFibonacci;

public class Ex1 {
    /**
     * Time complexity: 2^n, too bad as two same calls could start and then the call calls two methods again and again.
     * Space: O(n)
     *
     */
    public static int getNthFib(int n) {
        if(n == 2 ){
            return 1;
        }else if(n == 1){
            return 0;
        }else{
            return getNthFib(n-1) + getNthFib(n-2);
        }
    }


}

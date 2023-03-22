package principles.Thead;

import java.util.List;

public class Parallel {
    private static int doWork(int input) {
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){

        }
        return input;
    }
    public static void noParallelCall(){
        long start = System.currentTimeMillis();
        List.of(1,2,3,4,5)
                .stream()
                .map(w -> doWork(w))
                .forEach(s -> System.out.println(s + " "));

        System.out.println();
        var timeTaken = (System.currentTimeMillis()-start)/1000;
        System.out.println("Time:" + timeTaken);
    }
    public static void parallelCall(){
        long start = System.currentTimeMillis();
        List.of(1,2,3,4,5)
                .parallelStream()
                .map(w -> doWork(w))
                .forEach(s -> System.out.println(s + " "));

        System.out.println();
        var timeTaken = (System.currentTimeMillis()-start)/1000;
        System.out.println("Time:" + timeTaken);
    }

    public static void main(String[] args) {
        parallelCall();
    }
}

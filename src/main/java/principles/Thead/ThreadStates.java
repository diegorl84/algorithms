package principles.Thead;

import java.util.LinkedList;

public class ThreadStates implements Runnable {
    public static Thread thread1;
    public static ThreadStates obj;

    public static void main(String[] args) {
        obj = new ThreadStates();
        thread1 = new Thread(obj);

        System.out.println("State of thread1 after creating it - " + thread1.getState());
        thread1.start();

        System.out.println("State of thread1 after calling start() -" + thread1.getState());
    }

    @Override
    public void run() {
        DemoThread myThread = new DemoThread();
        Thread thread2 = new Thread(myThread);

        System.out.println("State of thread2 after creating it - " + thread2.getState());
        thread2.start();

        System.out.println("State of thread2 after calling start() -" + thread2.getState());

        try{
            //Moving thread1 to timed waiting state
            Thread.sleep(200);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println( "State of thread2 after calling .sleep() method on it - " + thread2.getState());
    }
}


class DemoThread implements Runnable {

    @Override
    public void run() {
        try{
            Thread.sleep(1500);
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("Thread id:" + Thread.currentThread().getId()
                + ", STATE: " + Thread.currentThread().getState());
    }


}

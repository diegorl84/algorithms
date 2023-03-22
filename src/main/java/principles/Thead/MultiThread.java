package principles.Thead;

class MultithreadingDemoClass extends Thread{
    @Override
    public void run() {
        try{
            System.out.println("Thread: "+ Thread.currentThread().getId() + " is running" );
        }catch (Exception e){
            System.out.println("Exception");
        }
    }
}

class MultithreadingDemoImplementingInterface implements Runnable {

    @Override
    public void run() {
        try{
            System.out.println("Thread: "+ Thread.currentThread().getId() + " is running" );
        }catch (Exception e){
            System.out.println("Exception");
        }
    }
}

public class MultiThread {

    Runnable sloth = () -> System.out.println("test");
    Runnable snake = () -> {int i= 10; i++;};

    public static void main(String[] args) {
        int threads = 20;
//        for (int i = 0; i < threads; i++) {
//            MultithreadingDemoClass object = new MultithreadingDemoClass();
//            object.start();
//        }

        for (int i = 0; i < threads; i++) {
            Thread object = new Thread(new MultithreadingDemoImplementingInterface());
            object.start();
        }

    }
}

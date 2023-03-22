package principles.Thead;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SheepManagerSynchronized {
    private AtomicInteger sheepCount = new AtomicInteger(0);
    public static final int THREAD_POOL = 20;
    Object herd = new Object();
    private void incrementAndReport() {

        synchronized (herd){
            System.out.println(sheepCount.incrementAndGet() + " ");
        }
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try{
            service = Executors.newFixedThreadPool(THREAD_POOL);
            SheepManagerSynchronized manager = new SheepManagerSynchronized();
            for (int i = 0; i < 10; i++) {
                service.submit(() -> manager.incrementAndReport());
            }
        }finally {
            if(service != null){
                service.shutdown();
            }
        }
    }
}

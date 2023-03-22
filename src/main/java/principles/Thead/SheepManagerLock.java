package principles.Thead;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SheepManagerLock {
    private AtomicInteger sheepCount = new AtomicInteger(0);
    public static final int THREAD_POOL = 20;
    Object herd = new Object();
    private void incrementAndReport() {
        /*
        The ReentrantLock class ensures that once a thread has called lock() and obtained the lock,
        all other threads that call lock() will wait until the first thread calls unlock().
        As far as which thread gets the lock next, that depends on the parameters used to create the Lock object.
         */
        Lock lock = new ReentrantLock();
        try {
           lock.lock();
            System.out.println(sheepCount.incrementAndGet() + " ");
        }finally {
           lock.unlock();
       }
    }

    public static void main(String[] args) {
        ExecutorService service = null;
        try{
            service = Executors.newFixedThreadPool(THREAD_POOL);
            SheepManagerLock manager = new SheepManagerLock();
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

package lt.codeacademy.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class MainThread {
    public static void main(String[] args) throws InterruptedException {
        //Thread thread = new Thread(); sukūrimas
        /*System.out.println("Programa pradėjo darbą.");
        Thread.sleep(5000);


        System.out.println("Thread vardas " + Thread.currentThread().getName());
        Thread t = new Thread(new MyRunnable());
        t.start();

        Thread t2 = new MyThread();
        t2.start();

        Thread t3 = new Thread(new SecondRunnable());
        t3.start();*/

        /*AtomicInteger atomicInteger = new AtomicInteger(0);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new ThirdRunnable(atomicInteger));
        executorService.execute(new ThirdRunnable(atomicInteger));
        executorService.execute(new ThirdRunnable(atomicInteger));

        executorService.shutdown();
        while (!executorService.isTerminated()){
            System.out.printf("%s still running\n", Thread.currentThread().getName());
            TimeUnit.SECONDS.sleep(3);
        }

        System.out.println("Programa darbą baigė.");*/

       Long sum = IntStream.range(1, 7)
                .parallel()
                .mapToObj(SumCallable::new)
                .map(SumCallable::call)
                .reduce(0L, Long::sum);

        System.out.printf("suma: %s\n", sum);

    }
}

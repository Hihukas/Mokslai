package lt.codeacademy.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ThirdRunnable implements Runnable{
    private final AtomicInteger atomicInteger;

    public ThirdRunnable(AtomicInteger atomicInteger) {
        this.atomicInteger = atomicInteger;
    }

    @Override
    public void run() {

        IntStream.range(1, 10).forEach(i->{
           int value = atomicInteger.get();
           int newValue = value + i;
           atomicInteger.compareAndSet(value, newValue);
            System.out.printf("%s, t: %s\n", i, Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}

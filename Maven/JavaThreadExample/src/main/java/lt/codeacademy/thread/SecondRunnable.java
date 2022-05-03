package lt.codeacademy.thread;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SecondRunnable implements Runnable{
    @Override
    public void run() {
        IntStream.range(1, 10).forEach(i ->{
            System.out.printf("%s, thread name: %s\n", i, Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e){
                e.printStackTrace();
            }
        });
    }
}

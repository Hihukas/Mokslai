package lt.codeacademy.thread;

import java.util.concurrent.Callable;
import java.util.stream.IntStream;

public class SumCallable implements Callable<Long> {
    private final int id;

    public SumCallable(int id) {
        this.id = id;
    }

    @Override
    public Long call(){
        System.out.println(Thread.currentThread().getName());
        return IntStream.range(1, 10).count() + id;
    }
}

package lt.codeacademy.thread.TaskOne;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class ProgressBarChecker extends Thread {
   private final ProgressBar progressBar;
   private final AtomicBoolean atomicBoolean;

    public ProgressBarChecker(ProgressBar progressBar) {
        this.progressBar = progressBar;
        atomicBoolean = new AtomicBoolean(true);
    }

    public void stopProgress(){
        atomicBoolean.set(false);
    }

    @Override
    public void run() {
        while(atomicBoolean.get()){
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(progressBar.getProgress());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

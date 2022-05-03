package lt.codeacademy.thread.TaskOne;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ProgressBar progressBar = new ProgressBar();
        ProgressBarChecker t = new ProgressBarChecker(progressBar);
        t.start();

        for(int i = 0; i < 10; i++){
            try {
                TimeUnit.SECONDS.sleep(1);
                progressBar.increaseProgress();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        t.stopProgress();
    }
}

package lt.codeacademy.thread.TaskOne;

public class ProgressBar {
    private int progress = 0;

    public synchronized int getProgress(){
        return  progress;
    }

    public synchronized void increaseProgress(){
        progress++;
    }
}

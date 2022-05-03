package lt.codeacademy.thread;

public class MyRunnable implements Runnable{
    @Override
    public void run() {

        try {
            Thread.sleep(5000);
            System.out.println("My custom runnable: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

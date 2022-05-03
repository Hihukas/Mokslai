package lt.codeacademy.thread;

public class MainThread {
    public static void main(String[] args) throws InterruptedException {
        //Thread thread = new Thread(); sukūrimas
        System.out.println("Programa pradėjo darbą.");
        Thread.sleep(5000);


        System.out.println("Thread vardas " + Thread.currentThread().getName());
        Thread t = new Thread(new MyRunnable());
        t.start();

        Thread t2 = new MyThread();
        t2.start();

        System.out.println("Programa darbą baigė.");

    }
}

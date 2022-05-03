package lt.codeacademy.thread;

public class MyThread extends Thread{
    @Override
    public void run() {
      try {
          for (int i = 0; i < 10; i++) {
              System.out.println("Thread name: " + Thread.currentThread().getName());
              if (i % 2 == 0) {
                  Thread.sleep(1000);
              }
          }
      }catch (Exception e){
          e.printStackTrace();
      }
    }
}

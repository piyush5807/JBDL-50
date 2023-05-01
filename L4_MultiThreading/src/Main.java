public class Main {

  private static class MyThread extends Thread{

    @Override
    public void run() {
      try {
        Thread.sleep(20000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      System.out.println(currentThread() + " " + currentThread().isDaemon());
    }
  }

  public static void main(String[] args) {

//    System.out.println(Thread.currentThread());
//
//    System.out.println("" + Runtime.getRuntime().maxMemory() +
//        " " + Runtime.getRuntime().totalMemory() + " " + Runtime.getRuntime().freeMemory());
//
//    System.out.println(Runtime.getRuntime().availableProcessors());

    MyThread t = new MyThread();
    t.setDaemon(false);
    t.start();

    int sum = 0;
    for(int i = 0; i < 100; i++){
      sum += i;
    }
    System.out.println(sum);

    // What's the diff b/w thread and frame ?

    // As soon as the main thread stops, our application will also stop
    // The application / JVM will run as long as there is even one foreground thread running
  }



  // Total Memory - 245.5 MB
  // Free Memory -  241 MB
  // Max Memory - 3.5 GB

  /**
   * Parallelism -
   * Concurrency -
   **/
}
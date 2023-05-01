public class ThreadUsingRunnable {

  private static class MyThread implements Runnable{

    @Override
    public void run() {
      System.out.println(Thread.currentThread());
    }
  }

  public static void main(String[] args) {

    Thread thread = new Thread(new MyThread());
    thread.start();

  }

}

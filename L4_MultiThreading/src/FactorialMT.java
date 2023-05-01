import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FactorialMT {

  private static class MyThread extends Thread{

    private int num;
    private BigInteger result;
    MyThread(int num){
      this.num = num;
      this.result = BigInteger.ONE;
    }

    @Override
    public void run() {

      System.out.println("Inside thread : " + currentThread().getName()
          + " , num = " + this.num);
      factorial();
    }

    public void factorial(){
      for(int i = 2; i < this.num; i++) {
        this.result = this.result.multiply(BigInteger.valueOf(i));
      }
    }
  }

  public static void main(String[] args) throws InterruptedException {

    List<Integer> nums = Arrays.asList(20000, 40000, 50000, 60000, 90000, 10000, 78000, 23000);
    List<BigInteger> result = new ArrayList<>();

    MyThread[] threads = new MyThread[nums.size()];

    long start = System.currentTimeMillis();

    for(int i = 0; i < nums.size(); i++){
      threads[i] = new MyThread(nums.get(i));
      System.out.println("thread = " + i + ", thread state = " + threads[i].getState());
      threads[i].start();
      System.out.println("thread = " + i + ", thread state = " + threads[i].getState());
    }


    for(int i = 0; i < nums.size(); i++){
      threads[i].join(10000); // Wait for 30 millis, after that resume the main thread
//      System.out.println("num = " + nums.get(i) + ", result = " + threads[i].result);
    }

    long end = System.currentTimeMillis();

    System.out.println(result);

    System.out.println("Time taken = " + (end - start));

  }

}

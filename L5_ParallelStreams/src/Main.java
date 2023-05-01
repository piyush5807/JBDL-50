import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args){

//    SampleSingleton s = new SampleSingleton();

    SampleSingleton s1 = SampleSingleton.getInstance();
    SampleSingleton s2 = SampleSingleton.getInstance();
    SampleSingleton s3 = SampleSingleton.getInstance();
    SampleSingleton s4 = SampleSingleton.getInstance();
    SampleSingleton s5 = SampleSingleton.getInstance();

    System.out.println(s1 + " " + s2 + " " + s3 + " " + s4 + " " + s5);

    // Ques1. Given a list of numbers, you have to find the first even number

    /**
     * Type of the stream
     * Type of terminal operation
     * Input collection type
     */

    List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    // 2 + 1 = 3
    // 3 + 4 = 7
    // 7 + 6 = 13
    // 13 + 8 = 21
    // 21 + 10 = 31

    // 35

//    System.out.println(nums.stream()
//        .parallel()
//        .filter(x -> {
//          System.out.println("x = " + x + ", thread = " + Thread.currentThread().getName());
//          return x % 2 == 0;
//        }).findAny());

//    int result = nums.stream().parallel().filter(x -> {
////      System.out.println("Inside filter: x = " + x + ", thread = " + Thread.currentThread().getName());
//      return x % 2 == 0;
//    }).reduce(0, (x,y) -> {
//      System.out.println("Inside reduce: x, y = " + x + " " + y + ", thread = " + Thread.currentThread().getName());
//      return x + y;
//    });
//
//    System.out.println(result);
  }
}
















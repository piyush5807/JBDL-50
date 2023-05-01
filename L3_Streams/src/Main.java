import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

  public static void main(String[] args) {

    System.out.println(Thread.currentThread());
//    System.out.println("Hello world!");

//    SampleInterface sampleInterface = new SampleInterface() {
//      @Override
//      public int add(int a, int b) {
//        return a + b;
//      }
//    };

    //----------------------------------------

//    SampleInterface sampleInterface2 = (a, b) -> a + b;

//    SampleFunctionalInterface sampleFunctionalInterface = (a, b) -> a + b;

    //-----------------------------------------

//    System.out.println(sampleFunctionalInterface.add(3, 5));
//    System.out.println(sampleInterface2.add(3, 5));

    Comparator<Integer> comparator = (a, b) -> a - b + 2;
    Comparator<String> comparator2 = (x, y) -> x.compareTo(y);

    Comparator<Integer> integerComparator = new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1 - o2 + 2;
      }
    };

    Comparator<String> stringComparator = new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o1.compareTo(o2);
      }
    };

//    System.out.println(comparator.compare(3, 5));
//    System.out.println(comparator.equals(3));

    SampleFunctionalInterface sampleFunctionalInterface = (a) -> {
      System.out.println("Inside lambda");
      return a != null;
    };

//    System.out.println(sampleFunctionalInterface.isNull(3));
//    System.out.println(sampleFunctionalInterface.equals(5));




    // After Java 8, there was a new feature which was added to make our lives easier
    // and that is lambda which we can use in place of anonymous inner class

    /**
     * Lambdas are short representation of your implementation where you don't have to write
       function name, class name, type of arguments and response
     */

    /*
        1. Memory
        2. Time because it's parallel
        3. Better utilization of resources
        4. Reduced Load
        5. Doesn't change the structure of inherent DS


        6. Pipelining and Readability
     */

    /** Q1. Given a list of integers, you have to find the sum of squares of odd numbers
     * L = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
     * Ans = 1*1 + 3*3 + 5*5 + 7*7 + 9*9 = 35 + 49 + 81 = 165
     */

    // Imperative
    List<Integer> nums = Arrays.asList(1, 3, 5, 4, 7, 6, 8, 9);

//    System.out.println(sum2(nums));

    printEvenNos(nums);

    // Ques. You are given a list of integers, you have find any even number

    // imperative (traditional) and declarative (streams)

    // Ques. You have to print all the even numbers

  }

  public static void printEvenNos(List<Integer> nums){

    nums.stream()
        .filter(x -> x % 2 == 0)
        .reduce(0, (x, y) -> add(x, y));   // f1 (a1, a2)
  }

  static long ops = 0;

  public static Integer findFirstEven(List<Integer> nums){

//    Integer result = nums.stream()
//        .filter(x -> x % 2 == 0)
//        .findFirst().orElseGet(() -> -1);

    return nums.stream()
        .sequential()
        .filter(x -> {
//          System.out.println("Traversing element :" + x);
          return x % 2 == 0;
        })
        .findAny().orElse(-1);

//    Integer result2 = nums.stream()
//        .filter(x -> x % 2 == 0)
//        .findFirst().orElseThrow(() -> new RuntimeException());

    /**
     * Result and Processing of streams depend upon these factors
     * Terminal Operation
     * Type of stream
     * Input collection type
     */

  }

  public static int sum2(List<Integer> nums){

    // Number of operations
    // Time taken

    long start = System.currentTimeMillis();

    nums.stream()
        .filter(a -> {
          ops += 1l;
          System.out.println("Filtering : " + a);
          return a % 2 == 1;
        })
        .map(x -> {
          ops += 1l;
          System.out.println("Mapping : " + x);
          return x * x;
        }).reduce(0, Main::add);

    long end = System.currentTimeMillis();

    System.out.println("Time taken for the program to run " + (end - start));
    System.out.println("Ops are = " + ops);

    return 0;
  }

  private static int add(int a, int b){
    return a + b;
  }

  private static int subtract(int a, int b){
    return a - b;
  }

  public static int sum(List<Integer> nums){

    long start = System.currentTimeMillis();

    int sum = 0;
    long ops = 0;
    for(int i = 0; i < nums.size(); i++){
      ops += 1l;
      if(nums.get(i) % 2 == 1){
        ops += 2;
        sum += nums.get(i) * nums.get(i);
      }
    }
    System.out.println("Ops are = " + ops);

    long end = System.currentTimeMillis();

    System.out.println("Time taken for the program to run " + (end - start));

    return sum;
  }
}

























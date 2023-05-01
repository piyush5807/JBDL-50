import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Factorial {

  public static void main(String[] args) {
    List<Integer> nums = Arrays.asList(20000, 40000, 50000, 60000, 90000, 10000, 78000, 23000);


    /**
     * Preference
     * 1. Correctness
     * 2. Optimization
     * 3. Code Readability
     */

    long start = System.currentTimeMillis();
    List<BigInteger> result = nums.stream()
        .map(Factorial::calculate)
        .collect(Collectors.toList());

    System.out.println(result);

    long end = System.currentTimeMillis();

    System.out.println("Time taken = " + (end - start));
  }

  public static BigInteger calculate(int num){
//    BigInteger result = BigInteger.ONE;
//    for(int i = 2; i <= num; i++){
//      result = result.multiply(BigInteger.valueOf(i));
//    }

    return IntStream.range(2, num + 1)
        .mapToObj(BigInteger::valueOf)
        .reduce(BigInteger.ONE, (x, y) -> x.multiply(y));

//    return result;
  }

}





















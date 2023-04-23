import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaces {


  public static void main(String[] args) {
    Supplier<Integer> supplier = () -> new Random().nextInt();

    System.out.println(supplier.get());

    // --------------------------------------------------------------------------

    Predicate<String> predicate = (a) -> a.length() > 5;

    System.out.println(predicate.test("Donkey"));

    // ---------------------------------------------------------------------------

//    Function<String, Integer> function = (a) -> Integer.parseInt(a);
//    System.out.println(function.apply("Str"));

    Function<Integer, Integer> function2 = (a) -> a * a;
    System.out.println(function2.apply(9));

    // -----------------------------------------------------------------------------

    Consumer<String> consumer = (a) -> System.out.println(a);
    consumer.accept("This car is expensive");

    // -----------------------------------------------------------------------------

    Runnable runnable = () -> System.out.println("This is just a random string");

    runnable.run();


    //------------------------------------------------------------------------------

    BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> a + b;
    System.out.println(biFunction.apply(5, 6));


  }

}

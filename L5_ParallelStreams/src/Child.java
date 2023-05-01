import java.util.Comparator;
import java.util.function.Function;

public class Child extends Base{

  public static void B(){
    A();
  }

  public static void main(String[] args) {
    Function<Integer, Integer> fn = (a) -> a * a;
    Function<Integer, Integer> fn2 = (b) -> b + b;

    fn2.equals(fn);

    Comparator<Integer> comp = new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return 0;
      }
    };
  }

}

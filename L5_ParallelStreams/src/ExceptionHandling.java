import java.io.FileNotFoundException;

public class ExceptionHandling {

  /**
   * Try catch block
   * Throw the exception back to the caller
   */

  public static void main(String[] args) throws CustomizedException {
    try {
      int a = 1 / 2;
      System.out.println(a);
    }catch (ArithmeticException ae) {
//      ae.printStackTrace();
      System.out.println("Got an arithmetic exception ");
      throw new CustomizedException("Got an arithmetic exception");
    }finally {
      System.out.println("Inside finally block");
    }

    int b = 10;
    System.out.println(b);
  }

}












import com.sun.org.apache.xerces.internal.dom.AbortException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.annotation.processing.FilerException;

public class NestedExceptions {

  public static void main(String[] args) throws FileNotFoundException {
    try {
      A();
    }catch (FileNotFoundException e){
      e.printStackTrace();
    }catch (Exception e){
      throw e;
    }

    System.out.println("After A in main");
  }

  public static void A() throws FileNotFoundException {
    try {
      B();
    }catch (ArithmeticException ae){
      System.out.println("Inside arithemtic catch block of function A");
    }catch (Exception e){
      System.out.println("Inside exception catch block of function A");
      throw e;
    }
//    try{
//      B();
//    }catch (ArithmeticException ae){
//      System.out.println("Inside function A");
//      ae.printStackTrace();
//      throw ae;
//    }
  }

  public static void B() throws FileNotFoundException {
    throw new FileNotFoundException();
  }

//  public static void C(){
//    try {
//      D();
//    }catch (ArithmeticException ae){
//      System.out.println("Inside function C");
//      ae.printStackTrace();
//      throw ae;
//    }
//  }
//  public static void D(){
//    try {
//      int a = 1 / 2;
//    }catch (ArithmeticException ae){
//      System.out.println("Inside function D");
//      ae.printStackTrace();
//      throw ae;
//    }
//  }

}

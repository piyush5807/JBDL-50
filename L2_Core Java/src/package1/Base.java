package package1;

public class Base {

  int a = 10;


  /**
   * Abstraction - achieved by abstract classes and interfaces
   * Encapsulation - properties of a real world entity --> member variable,
                     behaviours of a real world entity --> member functions
   * Polymorphism - Different ways to execute things
     Compile time -- Overloading of functions
                     Defining functions with the same name but diff signature (number and type of arguments)
     Runtime --      Overriding of functions
                     Defining functions with the same name and signature in the parent and child classes

   * Inheritance -- Capability of a class to inherit properties and behaviours from it's parent

   **/

  public final int sum(int num1, int num2){
    return num1 + num2;
  }

  public static int multiply(int num1, int num2){
    return num1 * num2;
  }

  public float sum(int sum1, int sum2, int sum3){
    return 0f;
  }

  public static void main(String[] args) {
    Base b = new Base();
    System.out.println(b.sum(1, 2));

    b.a = 30;
    b.a = 40;
  }

}

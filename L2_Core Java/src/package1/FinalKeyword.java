package package1;

public class FinalKeyword {

  /**
   * Same function = same name + same signature (number and type of arguments)
   **/

  /**
   * Variable - Whose value doesn't change thru out the course of the program
              Define final member variable in either non static block, constructor or while declaring
              Define final static variable in either static block or while declaring
   * Functions - Final functions in the base class cannot be overriden in the child class or in other way we can final functions are not modifiable
   * Classes - Final classes are not inheritable in nature and all functions of a final class are automatically final
   */

  public static final int a = 10;
  public final int b = 10;

//  static {
//    a = 10;
//  }


  FinalKeyword(){
//    this.a = 10;
  }

  public void doSomething(){
//    this.b = 20;
  }

  public static void main(String[] args) {
    FinalKeyword obj = new FinalKeyword();
//    obj.a = 20;
//    a = 10;
//    a = 20;
  }
}

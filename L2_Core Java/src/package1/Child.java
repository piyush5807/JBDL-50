package package1;

public class Child extends Base implements Interface1, Interface2{

//  public int sum(int num, int num2){
//    return num + num2 + 10;
//  }

//  @Override
//  public int subtract(int num1, int num2) {
//    return num1 - num2;
//  }

//  @Override
//  public int add(int num1, int num2) {
//    return num1 + num2;
//  }

//  @Override
//  public int subtract(int num1, int num2) {
//    return num1 - num2;
//  }

//  @Override
//  public int add(int num1, int num2){
//    return num1 + num2 + 1;
//  }

  /**
   * Case 1 : Reference of parent and instance of child
   * Case 2 : Reference of parent and instance of parent
   * Case 3: Reference of child and instance of child
   * Case 4: Reference of child and instance of parent
   */

  public int random(){
    return 0;
  }

  public int sum(double num1, int num2){
    return 0;
  }

  public static int multiply(int num1, int num2){
    return 0;
  }

//  @Override
//  public int random2() {
//    return 0;
//  }
//
//  @Override
//  protected int random3() {
//    return 0;
//  }

  public static void main(String[] args) {
//    Child obj = new Child();
//    Base obj2 = new Base();
//    Base obj3 = new Child();
//
//    System.out.println(obj.sum(1, 2)); // 13
//    System.out.println(obj2.sum(1, 2)); // 3
//    System.out.println(obj3.sum(1, 2)); // 13



//    System.out.println(obj.subtract(5, 4));
//    Interface2.number = 10;

    Child child = new Child();


  }

  @Override
  public int add(int num1, int num2) {
    return Interface2.super.add(num1, num2);
  }

  @Override
  public int subtract(int num1, int num2) {
    return Interface1.super.subtract(num1, num2);
  }

  @Override
  public int multiply() {
    return 0;
  }
}

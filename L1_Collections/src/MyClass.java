public class MyClass implements MyInterface{

  @Override
  public int add(int num1, int num2) {
    return num1 + num2;
  }

  @Override
  public int subtract(int num1, int num2) {
    return Math.abs(num1 - num2);
  }

  public int multiply(int num1, int num2){
    return num1 * num2;
  }
}

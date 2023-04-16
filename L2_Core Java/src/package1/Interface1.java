package package1;

public interface Interface1 {

  default int subtract(int num1, int num2){
    return num1 - num2;
  }
}

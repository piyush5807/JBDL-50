package package1;

public interface Interface2 {

  interface inner{

  }

  int number = 0; // static and final

  default int add(int num1, int num2){
    return num1 + num2;
  }

  default int subtract(int num1, int num2){
    return num2 - num1;
  }

  int multiply();

  // default ~ non abstract

}

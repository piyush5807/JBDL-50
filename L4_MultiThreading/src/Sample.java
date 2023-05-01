public class Sample {

  public static void main(String[] args) {
    A();
  }

  public static void A(){
    B();
  }

  public static void B(){
    C();
  }

  public static void C(){
    System.out.println("Inside function c");
  }
}

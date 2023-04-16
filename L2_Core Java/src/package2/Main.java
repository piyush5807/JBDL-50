package package2;

public class Main {

  /** Access Modifier
   * private - only inside the current class
   * default - only accessible inside the classes of current package
   * protected - only accessible inside the classes of current package and child classes of other package's classes
   * public - accessible everywhere
   **/

  private int num;

  int num2;

  protected int num3;

  public int num4;

//  private Main(){
//
//  }

  public static void main(String[] args) {
    System.out.println("Hello world!");

    Main main = new Main();
    main.num = 10;
    main.num2 = 20;
    main.num3 = 30;
  }
}
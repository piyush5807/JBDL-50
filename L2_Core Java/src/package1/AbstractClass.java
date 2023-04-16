package package1;

import java.util.Random;

public abstract class AbstractClass{

  public int var1;
  public int var2;

  public AbstractClass(){
    this.var1 = 10;
    this.var2 = 20;

    System.out.println(this.var1 + " " + this.var2);
  }

  public int random(){
    return new Random().nextInt();
  }

  public abstract int random2();

  protected abstract int random3();

  public static void main(String[] args) {

  }
}

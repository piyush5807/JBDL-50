public class Person implements Comparable<Person>{

  private String name;

  public Person(String name) {
    this.name = name;
  }

  /**
   * To show the difference b/w == and equals function
   **/
  @Override
  public boolean equals(Object obj) {
    Person p = (Person) obj;
    return this.name.equals(p.name);
  }

  public static void main(String[] args) {
    Person p1 = new Person("Raj");

    Person p2 = new Person("Raj");


    System.out.println(p1 == p2);
    System.out.println(p1.equals(p2));

//    System.out.println(p2.compareTo(p1));
  }

  @Override
  public int compareTo(Person o) {
    return this.name.compareTo(o.name);
  }
}

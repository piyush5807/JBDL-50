package package2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class Person {

  private String firstName;
  private String lastName;
  private int age;

  public Person(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  // hexadecimal - 0-9 a-f

  @Override
  public boolean equals(Object obj) {

    Person person = (Person) obj;
    if(obj == null){
      return false;
    }

    if(person.firstName.equals(this.firstName)
        && person.lastName.equals(this.lastName)){
      return true;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, age);
  }

  @Override
  public String toString() {
    return "Person = { firstName = " + this.firstName + ", lastName = " + this.lastName + ", age = " + this.age + "}";
  }

  public static void func(int...nums){
    for(Integer num: nums){
      System.out.println(num);
    }

  }

  public static void main(String[] args) {

    func(1, 2, 3, 4, 5);

    Person p1 = new Person("Ajay", "Dagar", 30);
    Person p2 = new Person("Ajay", "Dagar", 10);

    HashMap<Person, Boolean> map = new HashMap<>();
    map.put(p1, true);
    map.put(p2, false);

    System.out.println(p1.hashCode() + " " + p2.hashCode());


    System.out.println(map);

//    System.out.println(p1.hashCode() + " " + p1);
//    System.out.println(p2.hashCode() + " " + p2);


//    System.out.println(map);

//    Main main = new Main();
//    main.num2 = 10;
//    main.num3 = 40;
//

//    Main main = new Main();
  }


}

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Person {

    private int age;
    private String name;

    private String country;

    public Person(int age, String name, String country) {
        this.age = age;
        this.name = name;
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person(20, "John", "USA"),
                new Person(35, "Sam", "Italy"),
                new Person(15, "Jamie", "England"),
                new Person(30, "Robert", "Italy"),
                new Person(20, "James", "Ireland"),
                new Person(25, "Peter", "USA"),
                new Person(5, "Jsc", "Norway"),
                new Person(40, "Roger", "Netherlands"),
                new Person(50, "Jim", "USA")
        );


        q8();

    }

    public static void q1(List<Person> people){
        Double result = people.stream()
                .mapToInt(x -> x.getAge())
                .average().getAsDouble();
        System.out.println(result);
    }

    public static void q2(List<Person> people){
        List<Person> personList = people.stream()
                .filter(Person::checkIfValidPerson)
                .collect(Collectors.toList());

        System.out.println(personList);
    }

    public static void q3(List<Person> people){
        List<Person> personList = people.stream()
                .sorted(
                        Comparator.comparing(Person::getAge)
                        .thenComparing(Person::getName, Comparator.reverseOrder())
                )
                .collect(Collectors.toList());

        System.out.println(personList);
    }

    public static void q4(List<Person> people){
        Map<String, Long> personMap = people.stream()
                .collect(Collectors.groupingBy(Person::getCountry, Collectors.counting()));

        System.out.println(personMap);
    }

    public static void q5(List<Person> people){
        Map<String, Double> personMap = people.stream()
                .collect(
                        Collectors.groupingBy(Person::getCountry, Collectors.averagingDouble(Person::getAge)));

        System.out.println(personMap);
    }

    public static void q6(List<Person> people){
        Map<String, Person> personMap = people.stream()
                .collect(
                        Collectors.toMap(Person::getCountry,
                                Function.identity(),
                                BinaryOperator.maxBy(Comparator.comparing(Person::getAge))));

        System.out.println(personMap);

    }

    public static void q7(List<Person> people){

        Map<String, Long> personMap = people.stream()
                .collect(Collectors.groupingBy(Person::getCountry, Collectors.counting()));

        String countryWithMostPeople = Collections.max(personMap.entrySet(), Map.Entry.comparingByValue()).getKey();

        System.out.println(countryWithMostPeople);

    }

    public static void q8(){
        List<Integer> numbers = new Random()
                .ints(20, 0, 1000)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(numbers);
    }


    private static boolean checkIfValidPerson(Person person){
        Pattern pattern = Pattern.compile("[AEIOUaeiou]");
        return pattern.matcher(person.getName()).find() || person.getAge() > 20;
    }


}
public class Person {

    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Inside finalize function");
        // store the object being de-allocated in the db
    }

    public static void main(String[] args) {
        Person p1 = new Person(1, "Ram");
        p1.name = "Shyam";

        p1 = null;

        System.gc();
    }
}


/**
 * What's the diff b/w standalone java application and web server
 */









abstract public class Person {

    public String firstName;
    public String lastName;
    public final String SCHOOL_NAME = "ITAcademy";

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    abstract public void show(); /*{

        System.out.println("Person: " + firstName + " " + lastName);
    }*/
}
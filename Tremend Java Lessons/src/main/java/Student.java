public class Student extends Person {
    public String indexNumber;

    public Student(String firstName, String lastName, String indexNumber) {
        super(firstName, lastName);
        this.indexNumber = indexNumber;
    }

    @Override
    public void show() {
        System.out.println("Student: " + firstName + " " + lastName + " ID No. " + indexNumber);
    }
}
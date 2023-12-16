// Define a class called "Person"
class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter and setter methods for encapsulation
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Inheritance: Define a subclass "Student"
    static class Student extends Person {
        private String studentId;

        public Student(String name, int age, String studentId) {
            super(name, age); // Call the superclass constructor
            this.studentId = studentId;
        }

        public String getStudentId() {
            return studentId;
        }
    }

    // Polymorphism: Define a method that can accept both Person and Student
    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class Main {
    public static void main(String[] args) {
        // Create an object of the "Person" class
        Person person = new Person("Alice", 30);

        // Access the properties using getter methods
        System.out.println("Person Name: " + person.getName());
        System.out.println("Person Age: " + person.getName());

        // Create an object of the "Student" class (inherits from Person)
        Person.Student student = new Person.Student("Bob", 20, "S12345");

        // Access properties of the Student class
        System.out.println("Student Name: " + student.getName());
        System.out.println("Student Age: " + student.getName());
        System.out.println("Student ID: " + student.getStudentId());

        // Polymorphism: Demonstrate calling the same method on different objects
        Person personReference = new Person("Carol", 25);
        Person studentReference = new Person.Student("David", 22, "S67890");

        personReference.printInfo();
        studentReference.printInfo();
    }
}


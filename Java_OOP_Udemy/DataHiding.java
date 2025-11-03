// Data Hiding is a fundamental principle of Object-Oriented Programming (OOP)
// that restricts direct access to some of an object's components.
// This is typically achieved by declaring class fields as private
// and providing public getter and setter methods to access and update these fields.
// Abstraction is the concept of hiding the complex implementation details
// and exposing only the necessary and relevant parts of an object.
// This helps enhance code maintainability, readability, and security.
// Encapsulation is the bundling of data (attributes) and methods (functions)
// that operate on the data into a single unit or class.

class Person {
    private String name;
    private int age;

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Setter for age
    public void setAge(int age) {
        if (age >= 0) { // Basic validation
            this.age = age;
        }
    }
}

public class DataHiding {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Alice");
        person.setAge(30);

        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());

        // Attempting to access private fields directly will result in a compilation error
        // person.name = "Bob"; // Error
        // person.age = 25;    // Error
    }
}
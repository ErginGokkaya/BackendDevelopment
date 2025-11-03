// A constructor is a special method that is called when an object is instantiated.
// It has the same name as the class and does not have a return type.
// Constructors are used to initialize the object's properties.

// If no constructor is defined, the Java compiler provides a default constructor with no parameters. The modifier of the default constructor is the same as that of the class if the top level class is public or default.
// If a constructor is defined, the default constructor is not provided automatically.

// If a return type is specified by mistake, it becomes a regular method with the same name of the class, not a constructor.
// Types of modifiers allowed for constructors are: public, protected, private, and default (no modifier)
// but not static or final or abstract or synchronized or native or strictfp.

// first line of a constructor can be a call to another constructor in the same class using this() or a call to the superclass constructor using super().

// inheritance and overriding do not apply to constructors. A constructor cannot be inherited or overridden.
// Even abstract classes can have constructors, which are called when a subclass is instantiated.
// Interface cannot have constructors because they cannot be instantiated directly. And interfaces do not have instance variables to initialize. Their instance variables are public, static and final by default.

// If a parent class constructor has parameters, the subclass constructor must explicitly call the parent constructor using super() with appropriate arguments; otherwise, a compile-time error will occur.

// If a parent class throws checked exceptions in its constructor, the subclass constructor must either handle those exceptions using a try-catch block or declare them using the throws keyword. 

public class Constructors {
    // Default Constructor
    public Constructors() {
        System.out.println("Default Constructor called");
    }

    // Parameterized Constructor
    public Constructors(String message) {
        System.out.println("Parameterized Constructor called with message: " + message);
    }

    public static void main(String[] args) {
        // Creating an object using the default constructor
        Constructors obj1 = new Constructors();

        // Creating an object using the parameterized constructor
        Constructors obj2 = new Constructors("Hello, World!");
    }
}
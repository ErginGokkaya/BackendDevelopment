// abstract methodss are declared without an implementation
// child classes extending the abstract class must provide implementations for all abstract methods unless the child class is also declared abstract
// abstract classes cannot be instantiated directly
// A class having at least one abstract method must be declared abstract
// abstract classes can have constructors, fields, and concrete methods ( methods with implementation )


public class AbstractModifier {
    public static void main(String[] args){
        System.out.println("This class demonstrates the abstract modifier.");
    }

    public abstract void abstractMethod(); // abstract method declaration
}
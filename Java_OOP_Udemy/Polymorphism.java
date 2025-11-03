// Polymorphism is a core concept of Object-Oriented Programming (OOP)
// that allows objects of different classes to be treated as objects of a common superclass.
// It enables a single interface to represent different underlying forms (data types).
// The most common use of polymorphism is when a parent class reference
// is used to refer to a child class object.
// This allows methods to be called on the parent class reference,
// but the actual method that gets executed is determined at runtime
// based on the object's actual class type.

// overloading and overriding are two types of polymorphism.
// 1. Compile-time Polymorphism (Method Overloading):
//    This occurs when multiple methods in the same class have the same name
//    but different parameter lists (different type, number, or both). function signature consists of method name and parameter list. different function signature enables the programmer to overload the functions in the same class with the same name. Overloading is resolved during compile time.
// Automatic promotion of data types is also considered while resolving overloaded methods. The order of data type promotion is as follows:
// byte -> short -> char -> int -> long -> float -> double
// 2. Runtime Polymorphism (Method Overriding):
//      This occurs when a subclass provides a specific implementation
//      of a method that is already defined in its superclass.
//      The method in the subclass must have the same name, return type,
//      and parameters as the method in the superclass. Overriding is resolved during runtime.
// return type can be covariant in method overriding. Covariant return type means that the return type of the overriding method in the subclass can be a subtype of the return type declared in the superclass method. This is valid only for object return types, not for primitive data types.
// Overriding Special Cases:
// 1. A method declared as final in parent cannot be overridden. compile time error will be generated if we try to override a final method.
// 2. A method declared as static cannot be overridden, but it can be re-declared in the subclass. This is known as method hiding.
// 3. A private method cannot be overridden because it is not visible to the subclass. Redeclaring a private method in the subclass creates a new method that is independent of the superclass method.
// 4. The access level of the overriding method in the subclass cannot be more restrictive than that of the method in the superclass. default < protected < public
// 5. Constructors cannot be overridden.
// 6. If a method in the superclass throws certain checked exceptions,
//    the overriding method in the subclass cannot throw broader checked exceptions. However, it can throw narrower checked exceptions or any unchecked exceptions. Broader exceptions include more general exceptions, while narrower exceptions are more specific. For example, if the superclass method throws an IOException, the subclass method cannot throw a general Exception, but it can throw a FileNotFoundException, which is a subclass of IOException. For details, refer to Throwable, Exception, and IOException classes. For unchecked exceptions (subclasses of RuntimeException), there are no such restrictions; the overriding method can throw any unchecked exceptions regardless of what the superclass method declares.


interface Shape {
    void draw();
}
class Circle implements Shape {
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}
class Rectangle implements Shape {
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        Shape shape1 = new Circle();   // Parent class reference to child class object
        Shape shape2 = new Rectangle(); // Parent class reference to another child class object

        shape1.draw(); // Outputs: Drawing a Circle
        shape2.draw(); // Outputs: Drawing a Rectangle
    }
}
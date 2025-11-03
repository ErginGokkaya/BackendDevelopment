// Inheritance is a fundamental concept of Object-Oriented Programming (OOP)
// that allows a new class (subclass or derived class) to inherit properties
// and behaviors (fields and methods) from an existing class (superclass or base class).
// This promotes code reusability and establishes a hierarchical relationship
// between classes.
// inheritance is a Is-a relationship, meaning that the subclass is a specialized version
// of the superclass.

// Supported inheritance types include:
// 1. Single Inheritance: A subclass inherits from one superclass.
// 2. Multilevel Inheritance: A subclass inherits from a superclass, which in turn
//    inherits from another superclass.
// 3. Hierarchical Inheritance: Multiple subclasses inherit from a single superclass.
// Note: Java does not support multiple inheritance (a class inheriting from
// more than one class) directly to avoid complexity and ambiguity.
// Instead, Java uses interfaces to achieve similar functionality.
// Default methods in interfaces can provide a way to share code among multiple classes.
// But they don't cause the diamond (or ambiguity) problem associated with multiple inheritance.
// A default method in an interface is a method that has a body
// and is defined using the 'default' keyword. For example:
// interface MyInterface {
//     default void myDefaultMethod() { 
//         System.out.println("This is a default method.");
//     }    
// }

public class Inheritance {
    // Base class
    class Animal {
        void eat() {
            System.out.println("This animal eats food.");
        }
    }

    // Derived class
    class Dog extends Animal {
        void bark() {
            System.out.println("The dog barks.");
        }
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();
        Animal anotherDog = new Dog();

        // Calling method from the base class
        dog.eat();

        // Calling method from the derived class
        dog.bark();

        // anotherDog can access methods of Animal class
        anotherDog.eat(); 
        // anotherDog.bark(); // This would result in a compilation error
    }
}
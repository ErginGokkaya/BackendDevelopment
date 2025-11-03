// Compiler checks type compatibility in two steps:
// first, it checks the source type (the type of the value being assigned or passed) can be convertible or not.
// second, it checks whether the converted value can be assigned to the target type (the type of the variable or parameter receiving the value).
// If both checks pass, the compiler allows the assignment or method call; otherwise, it generates a compile-time error.
// Then JVM performs the actual conversion at runtime if necessary.
 
// 3 Rules of Type Casting in Java
// 1. Implicit Type Casting (Widening):
//    This occurs when a smaller data type is automatically converted to a larger data type.
//    For example, converting an int to a long or a float to a double.
//    This type of casting is done automatically by the Java compiler.
// 2. Explicit Type Casting (Narrowing):
//    This occurs when a larger data type is manually converted to a smaller data type.
//    For example, converting a double to an int or a long to a short.
//    This type of casting requires a cast operator and may lead to data loss if the value
//    being converted is outside the range of the target data type.
// 3. Casting between incompatible types:
//    This involves converting between types that do not have a direct relationship,
//    such as converting a char to an int or an object of one class to another class
//    in the same inheritance hierarchy. This type of casting may require explicit casting
//    and can lead to runtime exceptions if the cast is not valid.

public class TypeCasting {
    public static void main(String[] args) {
        // Implicit Type Casting (Widening)
        int intValue = 100;
        double doubleValue = intValue; // int to double
        System.out.println("Implicit Type Casting:");
        System.out.println("Integer Value: " + intValue);
        System.out.println("Double Value: " + doubleValue);

        // Explicit Type Casting (Narrowing)
        double anotherDoubleValue = 99.99;
        int anotherIntValue = (int) anotherDoubleValue; // double to int
        System.out.println("\nExplicit Type Casting:");
        System.out.println("Double Value: " + anotherDoubleValue);
        System.out.println("Integer Value: " + anotherIntValue);

        // Casting between incompatible types
        char charValue = 'A';
        int charToInt = (int) charValue; // char to int
        System.out.println("\nCasting between incompatible types:");
        System.out.println("Character Value: " + charValue);
        System.out.println("Character to Integer Value: " + charToInt);
    }
}
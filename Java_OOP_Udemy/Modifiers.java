// If a class identified with no modifier, it is accessible from package inside by default
// If a class identidied by public modifier, it is accessible from everywhere
// By identifying a class with abstract modifier, it cannot be instantiated directly
// A final class cannot be extended/inherited by other classes
// A strictfp class ensures that floating-point calculations conform to IEEE 754 standards
// Above modifiers are applicable only to top-level classes
// ******************************************************************************
// Modifiers applicable to member classes ( nested classes ) besides above modifiers are as follows:
// A member class can be identified with private, protected, public or default ( no modifier )
// A private member class is accessible only within the enclosing class
// A protected member class is accessible within the same package and by subclasses
// A public member class is accessible from everywhere 
// A default ( no modifier ) member class is accessible only within the same package
// A static member class ( static nested class ) can be instantiated without an instance of the enclosing class
// 
// A sealed class restricts which other classes or interfaces may extend or implement it
// 

public class Modifiers {
    public static void main(String[] args){
        System.out.println("This class demonstrates Java Modifiers.");
    }
}
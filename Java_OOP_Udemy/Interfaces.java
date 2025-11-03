// Every methods in an interface are implicitly public and abstract.
// A class implementing an interface must provide concrete implementations for all its methods.
// An overriding method cannot have a more restrictive access modifier than the method being overridden.
// So if an interface method is public, the implementing method must also be public.

interface Drawable {
    void draw();
}
interface Scalable {
    void scale(double factor);
}
class Shape implements Drawable, Scalable {
    private String name;
    private double size;

    public Shape(String name, double size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void draw() {
        System.out.println("Drawing " + name + " of size " + size);
    }

    @Override
    public void scale(double factor) {
        size *= factor;
        System.out.println("Scaled " + name + " to new size " + size);
    }
}

public class Interfaces {
    public static void main(String[] args) {
        Shape square = new Shape("Square", 3.0);
        square.draw();
        square.scale(1.5);
        square.draw();
    }
}
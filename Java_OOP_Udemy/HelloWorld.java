// package com.example.helloworld; // package declaration
// the class name must match the file name
class HelloWorld{
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Variables.sampleMethod(); // Calling the sample method from Variables class
    }
}


// To compile: javac HelloWorld.java
// javac is the Java compiler command.. it reads the source code from HelloWorld.java and compiles it into bytecode, generating a file named HelloWorld.class.
// To run: java HelloWorld
// java is the Java runtime command.. it launches the Java Virtual Machine (JVM) and executes the bytecode contained in HelloWorld.class, resulting in the output "Hello, World!" being printed to the console. 
// Note: When running the program, do not include the .class extension; just use the class name.

// JDK ( java development kit ) is required to compile and run Java programs. It includes the Java Runtime Environment (JRE), an interpreter/loader (java), a compiler (javac), an archiver (jar), a documentation generator (Javadoc), and other tools needed for Java development.

// javadoc is a tool that comes with the JDK and is used to generate HTML documentation from Java source code comments. It processes special comment blocks (/** ... */) in the code to create well-structured documentation for classes, methods, and fields.
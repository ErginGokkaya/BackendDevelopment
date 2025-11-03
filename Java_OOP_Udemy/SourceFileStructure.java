// a java file can contain multiple top-level classes but at most only one public class
// the name of the public class must match the name of the file
// if there is no public class, the file name can be arbitrary
// each class can have its own main method. it is allowed but not common practice.
// when a class file is run, only the main method of that specific class is executed.
// if the class does not have a main method, it cannot be run directly.
// ******************************************************************************
// Import statements 
// java.lang package is imported by default, so no need to import it explicitly
// lang package contains fundamental classes like String, Math, System, Thread, Exception etc.
// also, packages in current working directory are accessible without import statements
// ******************************************************************************
// a package declaration is an encapsulating mechanism to group related classes and interfaces together
// it helps to avoid name conflicts and organize code logically
// when compiling and running java files with package declarations, the directory structure must match the package structure. To compile files written by package com.example.helloworld, the command would be:
// javac com/example/helloworld/HelloWorld.java or javac -d . HelloWorld.java
// To run the compiled class, the command would be: java com.example.helloworld.HelloWorld or java -cp . com.example.helloworld.HelloWorld

// at most one package declaration is allowed per source file and it must be the first line in the file (excluding comments).
package com.example.demo; // to compile: javac -d . SourceFileStructure.java  

public class SourceFileStructure {
    // Class implementation
}
class B {
    // Class implementation
}
class C {
    // Class implementation
}
#SWRLAPI Built-in Library Example

This project provides a minimal example of a project that uses the [SWRLAPI](https://github.com/protegeproject/swrlapi/wiki)'s 
[Built-in Bridge](https://github.com/protegeproject/swrlapi/wiki/SWRLBuiltInBridge)
to create a [SWRL built-in library](https://github.com/protegeproject/swrlapi/wiki/SWRLBuiltInFAQ). 
It can be used as a starting point for developers who wish to create their own built-in library.

### Building and Installing

This example library defines a single built-in called ```stringsEqual``` that accepts two string argument. 
It returns ```true``` if both arguments are equal, and ```false``` otherwise. 

To build this library you must have the following items installed:

+ [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
+ A tool for checking out a [Git](http://git-scm.com/) repository
+ Apache's [Maven](http://maven.apache.org/index.html)

Get a copy of the latest code:

    git clone https://github.com/protegeproject/swrlapi-builtin-library-example.git 

Change into the ```swrlapi-builtin-library-example``` directory:

    cd swrlapi-builtin-library-example

Build it with Maven:

    mvn clean install

On build completion, your local Maven repository will contain generated ```swrlapi-builtin-library-example-${version}-jar-with-dependencies.jar```.
The Maven build process also creates a sub-directory called ```./swrl-builtins/strings``` and copies the generated
JAR to this directory. 

### Using this Built-in Library in Protégé 5

The JAR containing the built-in library must first be placed in Protégé's SWRL built-ins library directory so
that the library can be loaded.
A Protégé installation contains a SWRL built-in library directory from which it loads JARs that contain SWRL built-in libraries.
The name of this directory is operating system dependent.
On OS X this subdirectory is called ```./Contents/Java/plugins/swrl-builtins```.
A complete SWRL built-ins library directory path might be something like 
```/Applications/Protege-5.0.0/Protégé.app/Contents/Java/plugins/swrl-builtins```.
The SWRLTab plugin looks for the built-ins directory and loads all JARs inside it.

First copy the generate JAR containing the built-in library to the SWRL built-ins directory.
Then open Protégé 5.
Then ```StringsBuiltInLibraryUser.owl``` ontology.
If it is not already enabled, Go to the ```Windows->Tabs``` menu item and select the ```SQWRLTab``` item.
Navigate to the [SQWRLTab](https://github.com/protegeproject/swrlapi/wiki/SQWRLQueryTab) and select
and execute the SQWRL query that used the ```stringsEqual``` built-in.
If the library is correctly loaded the query should return "Yes - found it!".

### Using the Built-in Library in a SWRLAPI-based Application

The SWRLAPI's [SWRL Rule Engine API](https://github.com/protegeproject/swrlapi/wiki#SWRL_Rule_Engine_API) 
or [SQWRL Query API](https://github.com/protegeproject/swrlapi/wiki#SQWRL_Query_API)
can be used to run rules or queries that make use of this built-in.

The project JAR also contains a minimal example SWRLAPI application that illustates how
an application loads a user-defined built-in library and invoke the built-in from a SQWRL query in an ontology.
The ```./src/main/resources/owl``` directory contains an OWL file called ```StringsBuiltInLibraryUser.owl``` that defines
 a simple SQWRL query that uses the ```stringsEqual``` built-in to compare two strings.

The path of the built-in directory is supplied to this example application which then loads the built-in library from
the JAR, load an ontology containing a SQWRL query, and executes query.

To run the example application:

    mvn exec:java

Alternatively, execute the sample application as follows:

    java -jar target/swrlapi-builtin-library-example-${version}-jar-with-dependencies.jar ./swrl-builtins

If the library is correctly loaded by the query the application should display "Yes - found it!".

#### Questions

If you have questions about this library, please go to the main
Protégé website and subscribe to the [Protégé Developer Support
mailing list](http://protege.stanford.edu/support.php#mailingListSupport).
After subscribing, send messages to protege-dev at lists.stanford.edu.

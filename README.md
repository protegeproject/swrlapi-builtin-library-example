# SWRLAPI Built-in Library Example

This project provides a minimal example of a project that uses the [SWRLAPI](https://github.com/protegeproject/swrlapi/wiki)'s 
[Built-in Bridge](https://github.com/protegeproject/swrlapi/wiki/SWRLBuiltInBridge)
to create a [SWRL built-in library](https://github.com/protegeproject/swrlapi/wiki/SWRLBuiltInFAQ).
It also include an example application that loads this built-in library and uses a built-in defined by the library in a SQWRL query.
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

On build completion, your the target directory will contain a JAR called ```swrlapi-builtin-library-example-${version}.jar```.
A second JAR containing an example application using the built-in library is also generated, which is called
```swrlapi-builtin-library-example-${version}-jar-with-dependencies.jar```.

### Using this Built-in Library in Protégé 5

A Protégé installation contains a SWRL built-in library directory from which the [SWRLTab Plugin](https://github.com/protegeproject/swrltab-plugin/wiki) loads JARs that contain SWRL built-in libraries.
The JAR containing the built-in library must first be placed in this directory so that it can be loaded.
The name of this directory is operating system dependent.
On OS X this subdirectory is called ```./Contents/Java/plugins/swrl-builtins```.
A complete SWRL built-ins library directory path might be something like 
```/Applications/Protege-5.0.0/Protégé.app/Contents/Java/plugins/swrl-builtins```.
On startup the SWRLTab plugin looks for the built-ins directory and loads all built-in libraries defined in JAR files in the directory.

After copying the generated JAR SWRL built-ins directory open Protégé 5 and load the ```StringsBuiltInLibraryUser.owl``` ontology.
If it is not already enabled, Go to the ```Windows->Tabs``` menu item and select the ```SQWRLTab``` item.
Navigate to the [SQWRLTab](https://github.com/protegeproject/swrlapi/wiki/SQWRLQueryTab) and select
and execute the SQWRL query that used the ```stringsEqual``` built-in.
If the library is correctly loaded the query should return "Yes - found it!".

### Using the Built-in Library in a SWRLAPI-based Application

The SWRLAPI's [SWRL Rule Engine API](https://github.com/protegeproject/swrlapi/wiki#SWRL_Rule_Engine_API) 
or [SQWRL Query API](https://github.com/protegeproject/swrlapi/wiki#SQWRL_Query_API)
can be used to run rules or queries that make use of this built-in.

The project JAR contains a minimal example SWRLAPI application that illustates how
an application can load a user-defined built-in library and invoke the built-in from a SQWRL query in an ontology.
The ```./src/main/resources/owl``` directory contains an example OWL file called ```StringsBuiltInLibraryUser.owl``` that defines
 a simple SQWRL query that uses the ```stringsEqual``` built-in.
The application loads the built-in library from the JAR, load the ontology containing a SQWRL query, and then executes the query.

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

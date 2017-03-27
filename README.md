#SWRLAPI Built-in Library Example

This project provides a minimal example of a project that uses the [SWRLAPI](https://github.com/protegeproject/swrlapi/wiki)'s 
[Built-in Bridge](https://github.com/protegeproject/swrlapi/wiki/SWRLBuiltInBridge)
to create a [SWRL built-in library](https://github.com/protegeproject/swrlapi/wiki/SWRLBuiltInFAQ). 
It can be used as a starting point for developers who wish to create their own built-in library.

This example library defines a single built-in called ```stringsEqual``` that accepts two string argument. 
It returns ```true``` if both arguments are equal, and ```false``` otherwise. 

Instructions for building and installing this library are outlined below.

The ```./src/main/resources/owl``` directory contains an OWL file called ```StringsBuiltInLibrary.owl```
that [defines this built-in](https://github.com/protegeproject/swrlapi/wiki/SWRLBuiltInBridge#defining-built-ins-in-owl) so that it can be used by importing ontologies. 
An example importing ontology called ```StringsBuiltInLibraryUser.owl``` defines a simple SQWRL query that uses the
```stringsEqual``` built-in to compare two strings.

This built-in library can be used in two primary ways:

* Interactively, in the [Protégé 5 ontology editor](http://protege.stanford.edu/)
* In [SWRLAPI](https://github.com/protegeproject/swrlapi/wiki)-based applications

### Using this Built-in Library in Protégé 5

The JAR containing the built-in library must first be placed in Protégé's class path so
that the built-ins it defines can be resolved.
A Protégé installation contains a plugin directory that can be used for this purpose.
The name of the directory is operating system dependent.
On OS X this subdirectory is called ```./Contents/Java/plugins/```.
So a complete plugin directory path might be something like ```/Applications/Protege-5.0.0/Protégé.app/Contents/Java/plugins/```.

Copy the JAR to the plugins directory and then open Protégé 5.

To run the SQWRL query, open the importing ontology in Protégé.
If it is not already enabled, Go to the ```Windows->Tabs``` menu item and select the ```SQWRLTab``` item.
Navigate to the [SQWRLTab](https://github.com/protegeproject/swrlapi/wiki/SQWRLQueryTab) and select
and execute the SQWRL query that used the ```stringsEqual``` built-in.

### Using the Built-in Library in a SWRLAPI-based Application

First use OWLAPI to create an ontology and load the ontology defining the built-in.
The SWRLAPI's [SWRL Rule Engine API](https://github.com/protegeproject/swrlapi/wiki#SWRL_Rule_Engine_API) 
or [SQWRL Query API](https://github.com/protegeproject/swrlapi/wiki#SQWRL_Query_API)
can then be used to run rules or queries that make use of this built-in.

### Building and Installing

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

On build completion, your local Maven repository will contain generated ```swrlapi-builtin-library-example-${version}.jar```.
The ```./target``` directory will also contain this JAR.

As per the [built-in library installation instructions](https://github.com/protegeproject/swrlapi/wiki/SWRLBuiltInBridge#Loading_a_Builtin_Implementation_Class_at_Runtime), 
this JAR must be available in an application's class path for dynamic runtime resolution.

#### Questions

If you have questions about this library, please go to the main
Protégé website and subscribe to the [Protégé Developer Support
mailing list](http://protege.stanford.edu/support.php#mailingListSupport).
After subscribing, send messages to protege-dev at lists.stanford.edu.

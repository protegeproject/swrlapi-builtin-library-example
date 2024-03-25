package org.swrlapi.example;

import java.net.URL;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Set;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyIRIMapper;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.util.SimpleIRIMapper;
import org.swrlapi.factory.SWRLAPIFactory;
import org.swrlapi.parser.SWRLParseException;
import org.swrlapi.sqwrl.SQWRLQueryEngine;
import org.swrlapi.sqwrl.SQWRLResult;
import org.swrlapi.sqwrl.exceptions.SQWRLException;

public class SWRLAPIBuiltInExample {
  public static void main(String[] args) {
    try {
      // Create an empty OWL ontology using the OWLAPI
      OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
      OWLOntology ontology = ontologyManager.createOntology();

      URL owlFileResource = SWRLAPIBuiltInExample.class.getResource("/owl/strings.owl");
      Set<OWLOntologyIRIMapper> mappers = Collections.singleton(
          new SimpleIRIMapper(IRI.create("http://www.semanticweb.org/dell/ontologies/2016/6/untitled-ontology-42"),
              IRI.create("file://".concat(owlFileResource.getFile()))));
      ontologyManager.setIRIMappers(mappers);

      // Create SQWRL query engine using the SWRLAPI
      SQWRLQueryEngine queryEngine = SWRLAPIFactory.createSQWRLQueryEngine(ontology);
      // Register custom SWRLBuiltInLibraryImpl
      queryEngine.getSWRLAPIOWLOntology().getSWRLBuiltInLibraryManager()
          .loadExternalSWRLBuiltInLibraries(Path.of("src/main/java/org/swrlapi/builtins").toFile());

      // Create and execute a SQWRL query using the SWRLAPI
      SQWRLResult result = queryEngine
          .runSQWRLQuery("q1", "strings:stringsEqual(\"a\", \"a\") -> sqwrl:select(\"Yes!\")");

      // Print the result
      if (result.next())
        System.out.println("Answer: " + result.getLiteral(0).getString());

    } catch (OWLOntologyCreationException e) {
      System.err.println("Error creating OWL ontology: " + e.getMessage());
      System.exit(-1);
    } catch (SWRLParseException e) {
      System.err.println("Error parsing SQWRL query: " + e.getMessage());
      System.exit(-1);
    } catch (SQWRLException e) {
      System.err.println("Error running SQWRL query: " + e.getMessage());
      System.exit(-1);
    } catch (RuntimeException e) {
      System.err.println("Error starting application: " + e.getMessage());
      System.exit(-1);
    }
  }
}

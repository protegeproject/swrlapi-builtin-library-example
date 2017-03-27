package org.swrlapi.example;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.swrlapi.factory.SWRLAPIFactory;
import org.swrlapi.parser.SWRLParseException;
import org.swrlapi.sqwrl.SQWRLQueryEngine;
import org.swrlapi.sqwrl.SQWRLResult;
import org.swrlapi.sqwrl.exceptions.SQWRLException;

public class SWRLAPIBuiltInExample
{
  public static void main(String[] args)
  {
    try {
      // Create an empty OWL ontology using the OWLAPI
      OWLOntologyManager ontologyManager = OWLManager.createOWLOntologyManager();
      OWLOntology ontology = ontologyManager.createOntology();

      // Create SQWRL query engine using the SWRLAPI
      SQWRLQueryEngine queryEngine = SWRLAPIFactory.createSQWRLQueryEngine(ontology);

      queryEngine
        .addSWRLBuiltIn(IRI.create("http://swrl.stanford.edu/ontologies/built-ins/5.1.0/strings.owl#stringsEqual"));
      queryEngine.getSWRLAPIOWLOntology().getIRIResolver()
        .setPrefix("strings", "http://swrl.stanford.edu/ontologies/built-ins/5.1.0/strings.owl#");

      // Create and execute a SQWRL query using the SWRLAPI
      SQWRLResult result = queryEngine
        .runSQWRLQuery("q1", "strings:stringEqual(\"a\", \"a\") -> sqwrl:select(\"Yes!\")");

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

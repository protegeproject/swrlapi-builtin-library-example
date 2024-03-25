package org.swrlapi.builtins.strings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.swrlapi.builtins.AbstractSWRLBuiltInLibrary;
import org.swrlapi.builtins.arguments.SWRLBuiltInArgument;
import org.swrlapi.exceptions.SWRLBuiltInException;

public class SWRLBuiltInLibraryImpl extends AbstractSWRLBuiltInLibrary {
  private static final String Namespace = "http://swrl.stanford.edu/ontologies/built-ins/5.0.0/strings.owl#";
  private static final String Prefix = "strings";

  private static final String[] BuiltInNames = { "stringsEqual" };

  public SWRLBuiltInLibraryImpl() {
    super(Prefix, Namespace, new HashSet<>(Arrays.asList(BuiltInNames)));
  }

  @Override
  public void reset() {
  }

  public boolean stringsEqual(List<SWRLBuiltInArgument> arguments) throws SWRLBuiltInException {
    final int argument1Number = 0, argument2Number = 1, numberOfArguments = 2;

    checkNumberOfArgumentsEqualTo(numberOfArguments, arguments.size());

    String argument1 = getArgumentAsAString(argument1Number, arguments);
    String argument2 = getArgumentAsAString(argument2Number, arguments);

    return argument1.equals(argument2);
  }

}

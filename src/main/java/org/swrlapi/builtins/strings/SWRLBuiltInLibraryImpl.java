package org.swrlapi.builtins.strings;

import org.swrlapi.builtins.AbstractSWRLBuiltInLibrary;
import org.swrlapi.builtins.arguments.SWRLBuiltInArgument;
import org.swrlapi.exceptions.SWRLBuiltInException;

import java.util.List;

public class SWRLBuiltInLibraryImpl extends AbstractSWRLBuiltInLibrary
{
  public SWRLBuiltInLibraryImpl() { super("StringsBuiltIns"); }

  @Override public void reset() { }

  public boolean stringsEqual(List<SWRLBuiltInArgument> arguments) throws SWRLBuiltInException
  {
    final int argument1Number = 0, argument2Number = 1, numberOfArguments = 2;

    checkNumberOfArgumentsEqualTo(numberOfArguments, arguments.size());

    String argument1 = getArgumentAsAString(argument1Number, arguments);
    String argument2 = getArgumentAsAString(argument2Number, arguments);

    return argument1.equals(argument2);
  }

}

package edu.ics211.h02;

public class MethodCall extends BasicStatement {

	public MethodCall(String[] tokenVals) throws InvalidStatementException {
		super(tokenVals);
		//ensures the token provided to this function is a valid one. 
		//e.x: "hello();"
		if(tokens.length < 4||!isValidIdentifier(tokens[0]) ||!tokens[1].equals("(") ||
				!tokens[tokens.length-2].equals(")")|| !tokens[tokens.length-1].equals(";")  ) {
			tokens = null;
					throw new InvalidStatementException("Bad method call. MethodCall Object not created");
					
		}
		
	}
//returns method name
	// if tokens = "hello();" then this returns hello.
	public String getMethodName() {
		return tokens[0];
		
	}
}

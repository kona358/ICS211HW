package edu.ics211.h03;

public class MethodCall extends BasicStatement {

	public MethodCall(String[] tokenVals) throws InvalidStatementException {
		super(tokenVals);
		if (tokens.length < 4 ||
			!isIdentifier(tokens[0]) ||
			!tokens[1].equals("(") ||
			!tokens[tokens.length-2].equals(")") ||
			!tokens[tokens.length-1].equals(";")) {
			tokens = null;
			throw new InvalidStatementException("invalid tokens, " + 
				"MethodCall object not created");
		}
	}
	
	public MethodCall(String method, String[] parameters) throws InvalidStatementException {
		//refer to makeTokens in Statement
		this(makeTokens("MethodCall", method, "(", parameters));	}

	public String getMethodName() {
		return tokens[0];
	}
	
}

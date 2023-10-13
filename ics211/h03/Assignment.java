package edu.ics211.h03;

public class Assignment extends BasicStatement {
	
	public Assignment(String[] tokenVals) throws InvalidStatementException {
		super(tokenVals);
		if (tokens.length < 4 ||
			!isIdentifier(tokens[0]) ||
			!tokens[1].equals("=") ||
			!tokens[tokens.length-1].equals(";")) {
			tokens = null;
			throw new InvalidStatementException("tokens invalid, " + 
				"Assignment object not created");
		}
	}
	public Assignment(String variable, String[] expression) throws InvalidStatementException {
		//refer to makeTokens in Statement
		
this(makeTokens("Assignment", variable, "=", expression));
}
	public String getVariable() {
		return tokens[0];
	}

}

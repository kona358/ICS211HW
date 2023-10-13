package edu.ics211.h03;

public class WhileLoop extends CompoundStatement {

	public WhileLoop(String[] tokenVals) throws InvalidStatementException {
		tokens = tokenVals;
		if (tokens.length < 6 ||
			!tokens[0].equals("while") ||
			!tokens[1].equals("(")) {
			tokens = null;
			throw new InvalidStatementException("Invalid tokens, " + 
			    "WhileLoop object not created");
		}
	}
	
	public WhileLoop(String[] condition, Statement[] loopBody) throws InvalidStatementException {
		// this constructor creates a whileloop object, and concatenates its parameters into a valid format
		//i.e while ( x < 3 ) { y = 5 } 
		String delim = ",";
		StringBuilder sb = new StringBuilder();
		sb.append("while");
		sb.append(delim);
		sb.append("(");
		sb.append(delim);
		for (int i = 0; i < condition.length; i++) {
			sb.append(condition[i]);
			sb.append(delim);
		}
		sb.append(")");
		sb.append(delim);
		sb.append("{");
		sb.append(delim);
		String[] statementTokens = tokenizeStatements(loopBody);
		for (int i = 0; i < statementTokens.length; i++) {
			sb.append(statementTokens[i]);
			sb.append(delim);
		}
		sb.append("}");
		tokens = sb.toString().split(delim);
	}

	public int numberOfParts() {
		return 1;
	}
	
}

package edu.ics211.h03;

public abstract class Statement {

	protected String[] tokens;

	public abstract boolean isCompound();

	public boolean isIdentifier(String s) {
		s = s.trim();
		if (s.length() == 0) {
			return false;
		}
		if (!Character.isJavaIdentifierStart(s.charAt(0))) {
			return false;
		}
		for (int i = 1; i < s.length(); i++) {
			if (!Character.isJavaIdentifierPart(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	protected static String[] makeTokens(String className, String first, String second,
		String[] list) {
			//adds the string params to a single string, while adding formatting
			//splits the string into an array of type string
		String delim = "'"; // used to split StringBuilder output into String[]
		StringBuilder sb = new StringBuilder();
		sb.append(first);
		sb.append(delim);
		sb.append(second);
		sb.append(delim);
		for (int i = 0; i < list.length; i++) {
			sb.append(list[i]);
			sb.append(delim);
		}
		// only have requirement for second to last token for MethodCall
		if (className.equals("MethodCall")) {
			sb.append(")");
			sb.append(delim);
		}
		sb.append(";"); // last token

		return sb.toString().split(delim);
	}

	protected static String[] tokenizeStatements(Statement[] statements) {
		//takes an array of statements
		// adds each token of the statements to a string
		// and splits them into an array of type string 
		String delim = "'";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < statements.length; i++) {
			for (int j = 0; j < statements[i].tokens.length; j++) {
				sb.append(statements[i].tokens[j]);
				if (i < statements.length - 1) {
					sb.append(delim);
				}
			}
		}
		return sb.toString().split(delim);
	}

	protected String concatenate(String[] tokenVals) {
		//turns array into string format, with a space separating each element
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tokenVals.length; i++) {
			sb.append(tokenVals[i]);
			if (i < tokenVals.length - 1) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}

	public String toString() {
		return concatenate(tokens);
	}

	public boolean equals(Object statement) {
		if (statement == null) {
			return false;
		}
		Statement st2 = (Statement)statement;
		if (st2.getClass() != this.getClass()) {
			return false;
		}
		if (st2.tokens.length != this.tokens.length) {
			return false;
		}
		for (int i = 0; i < this.tokens.length; i++) {
			if (!st2.tokens[i].equals(this.tokens[i])) {
				return false;
			}
		}
		return true;
	}

}
package edu.ics211.h03;
public class Conditional extends CompoundStatement {
   
   public Conditional(String[] tokens) throws InvalidStatementException {
      this.tokens = tokens;
      if (tokens.length < 5 ||
         !tokens[0].equals("if") || !tokens[1].equals("(") ||
         !tokens[tokens.length - 1].equals("}") || 
         !containsElse(tokens)) {
         throw new InvalidStatementException("Invalid tokens for Conditional Statement");
      }
   }
   
   public Conditional(String[] condition, Statement[] thenPart,
			Statement[] elsePart) throws InvalidStatementException {
				// this constructor creates a conditional object, and concatenates its parameters into a valid format
				//i.e if ( x < 3 ) { y = 5 } else { y = 4 } 
			String delim = ",";
			StringBuilder sb = new StringBuilder();
			sb.append("if");
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
			String[] thenTokens = tokenizeStatements(thenPart);
	        // use a for loop to add in the thenTokens
			for (int i = 0; i < thenTokens.length; i++) {
				sb.append(thenTokens[i]);
				sb.append(delim);
			}
			sb.append("}");
			sb.append(delim);
			sb.append("else");
			sb.append(delim);
			sb.append("{");
			sb.append(delim);
			//for loop to add in the else tokens
			String[] elseTokens = tokenizeStatements(elsePart);
			for (int i = 0; i < elseTokens.length; i++) {
				sb.append(elseTokens[i]);
				sb.append(delim);
			}
			sb.append("}");

			tokens = sb.toString().split(delim);
		}

public int numberOfParts() {
      return 2;
   }
   
   private boolean containsElse(String[] tokens) {
      for (int i = 2; i < tokens.length - 1; i++) {
         if (tokens[i].equals("else")) {
            return true;
         }
      }
      return false;
   }
}

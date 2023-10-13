/**
 * 
 */
package edu.ics211.h02;

/**
 * @author lucas
 *
 */
public abstract class Statement {
	protected String[] tokens;

	public abstract boolean isCompound();
//ensures the token provided to this function is a valid one. 
//e.g (, ), {,}, while, if
	public boolean isValidIdentifier(String s) {
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

	public String toString() {
		String tokenString = String.join(" ", tokens);

		return tokenString;
		//Incase above is invalid for the purposes of this project:
		/* String tokenString = "";
		// for(String s: tokens) {
		// tokenString+=s;
		// tokenString+=" ";
		// }
		//
		return tokenString;
		*/ 
	}

	public boolean equals(Object obj) {
//ensures that if the obj is null, then it defaults to false
		if (obj == null) {
			return false;
		}
		Statement st = (Statement) obj;
		if (st.getClass() != this.getClass()) {
			return false;
		}
		if ((this.tokens.length != st.tokens.length)) {
			return false;
		}
		/*
		 * Use a for loop that checks to see that each token
		 * is equal to the corresponding token in st
		 */
		for (int i = 0; i<this.tokens.length; i++) {
			if(this.tokens[i] != st.tokens[i]){
				return false;
			}

			
		}

		return true;
	}

}

package edu.ics211.h02;
//Statement ->CompoundStatement->Conditional
public class Conditional extends CompoundStatement {

	public Conditional(String[] tokenVals) throws InvalidStatementException{ 
super(tokenVals); // sets tokenVals to tokens
//ensures the token provided to this function is a valid one. 
//e.x "if(x<4) {x = 5} else{ x = 6}"
if(tokens.length <9 || !tokens[0].equals("if")|| !tokens[1].equals("(") ||!containsElse(tokens)
		|| !tokens[tokens.length-1].equals("}")){
	tokens = null;
	throw new InvalidStatementException("Invalid Tokens, Conditional method not created");
	
}
	}

	@Override
	public int numberOfParts() {
//a conditional has 2 parts, the if and else statements	
		return 2;
	}

	//used to see if an array has the string "else" in the 3rd through second to last indices
	private boolean containsElse(String[] tokens) {
		for(int i=2; i<tokens.length-1; i++) {
			if(tokens[i].equals("else")) {
				return true;
			}
	}
		return false;

}
}


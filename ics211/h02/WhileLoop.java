package edu.ics211.h02;

public class WhileLoop extends CompoundStatement {

	public WhileLoop(String[] tokenVals) throws InvalidStatementException {
		super(tokenVals);
		//ensures the token provided to this function is a valid one. 
		//e.x: while(x<4){x=5;}
		if(tokens.length <6 || !tokens[0].equals("while")|| !tokens[1].equals("(") 
				|| !tokens[tokens.length-1].equals("}")) {
			tokens = null;
			throw new InvalidStatementException("Invalid Tokens, While Statement object not created");
			
		}
			}

	
// a while loop only has one part to be executed, the inside of the while loop
	@Override
	public int numberOfParts() {
		// TODO Auto-generated method stub
		return 1;
	}

}

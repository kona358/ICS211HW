package edu.ics211.h02;

public class Assignment extends BasicStatement {

    public Assignment(String[] tokenVals) throws InvalidStatementException {
    	super(tokenVals); // this sets tokensVals to tokens from BasicStatment from Statement
    	//will do nothing if tokens is valid input for an assignment
    	//Valid e.x: "x, =, 4;"
    	 if (tokens.length < 4 ||!isValidIdentifier(tokens[0]) ||
    	            !tokens[1].equals("=") ||
    	            !tokens[tokens.length - 1].equals(";")) {
    	                tokens = null;
    	                throw new InvalidStatementException("Invalid tokens for assignment");
    	                // statement exception has occurred
    	        }
    	 
    	
    	
    }
	//returns var name
    //if tokens = "x,=,4", then this returns x
	public  String getVariable() {
		return tokens[0];	
	}

	
	}

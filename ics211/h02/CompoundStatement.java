package edu.ics211.h02;
//Statement -> Compound Statement
public abstract class CompoundStatement extends Statement {
	CompoundStatement(String[] tokenVals){
		tokens = tokenVals; //constructor for conditional + while loop classes
	}
	
	
	public boolean isCompound() {
		return true;
	}
	
	public abstract int numberOfParts();
}

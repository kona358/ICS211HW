package edu.ics211.h03;

public class BasicStatement extends Statement {

	public BasicStatement(String[] tokenValues) {
		tokens = tokenValues;
	}
	
	public boolean isCompound() {
		return false;
	}

}

package edu.ics211.h02;

public class BasicStatement extends Statement {

public BasicStatement(String[] tokenValues) {
	tokens = tokenValues;
}

	@Override
	public boolean isCompound() {
		// TODO Auto-generated method stub
		return false;
	}

}

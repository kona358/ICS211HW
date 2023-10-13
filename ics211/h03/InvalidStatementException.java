package edu.ics211.h03;

public class InvalidStatementException extends Exception {

	public InvalidStatementException() {
		super("An InvalidStatementException occurred");
	}
	
	public InvalidStatementException(String msg) {
		super(msg);
	}

}

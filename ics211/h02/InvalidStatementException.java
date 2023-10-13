package edu.ics211.h02;

public class InvalidStatementException extends Exception{
	InvalidStatementException(){
		super("An invalid Statement Exception Error");
	}
	InvalidStatementException(String error){
		super(error);
		
	}

}

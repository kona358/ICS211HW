package edu.ics211.h03;

public interface Programmer {
	Assignment makeAssignment();
	MethodCall makeMethodCall();
	WhileLoop makeWhileLoop();
	Conditional makeConditional();
	Statement makeStatement();
}

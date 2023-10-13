package edu.ics211.h03;
import java.util.Random;
public class RandomProgrammer implements Programmer {
Random random = new Random();

	
	
	
	final static String[] variables = { "a", "b", "c", "d", "i", "j", "k",
			"m", "n", "x", "y", "count", "size" };
	final static String[] methodNames = {"print", "trim", "sort", "cut", "replace", "retrieve",
			"insert", "copy", "remove", "add", "reverse"};
	final static String[] mathOperators = {"+", "-", "*", "/", "%"};
	final static String[] relationalOperators = {"<", ">", "<=", ">=", "==", "!="};
	
	private String makeChoice(String[] choices) {
		//helper
		int choice = random.nextInt(choices.length);
		return choices[choice];
	}
	
	private String getIntOrVariable() {
		//helper method
		int option = random.nextInt(2);  // either 0 or 1
		if (option == 1) {
			return makeChoice(variables);
		}
		else {
			return "" + random.nextInt(100);//bound to 100 for readability. adding to "" converts to String
		}
	}
	
	private String[] makeExpression() {
//helper method
//generates 
		String[] exp;
		int choice = random.nextInt(2);
		if (choice == 0) {
			exp = new String[1];
			exp[0] = getIntOrVariable();
		}
		else {
			exp = new String[3];
			exp[0] = getIntOrVariable();
			exp[1] = makeChoice(mathOperators);
			exp[2] = getIntOrVariable();
		}
		return exp;
	}
	private String[] makeArguments() {
	//helper method
//creates a random amount (0-3) of arguments for method call statements
// gets the args from makeExpression
//and concats them based on the num of params 
		int numParameters = random.nextInt(4);
		String[] args = null;
		if (numParameters == 0) {
			args = new String[] {};
		}
		else if (numParameters == 1) {
			String[] exp = makeExpression();
			args = new String[exp.length];
			for (int i = 0; i < exp.length; i++) {
				args[i] = exp[i];
			}
		}
		else if (numParameters == 2) {
			String[] exp1 = makeExpression();
			String[] exp2 = makeExpression();
			args = new String[exp1.length + exp2.length + 1]; // add 1 for the comma
			for (int i = 0; i < exp1.length; i++) {
				args[i] = exp1[i];
			}
			args[exp1.length] = ","; // places a comma in the last index
			for (int i = 0; i < exp2.length; i++) {
				args[i + exp1.length+1] = exp2[i];
			}
		}
		else if (numParameters == 3) {
			String[] exp1 = makeExpression();
			String[] exp2 = makeExpression();
			String[] exp3 = makeExpression();
			args = new String[exp1.length + exp2.length + exp3.length + 2]; // add 2 for the commas
			for (int i = 0; i < exp1.length; i++) {
				args[i] = exp1[i];
			}
			args[exp1.length] = ","; 
			for (int i = 0; i < exp2.length; i++) {
				args[i + exp1.length + 1] = exp2[i];
			}
			args[exp1.length + exp2.length + 1] = ",";
			for (int i = 0; i < exp3.length; i++) {
				args[i + exp1.length + exp2.length + 2] = exp3[i];
			}
		}
		return args;
	}
	
	private String[] makeTestCondition() {
		//creates a string array for a compound statement like x < 3 or y==2
		String[] conditionParts = new String[3];
		conditionParts[0] = getIntOrVariable(); // picks an int or var
		conditionParts[1] = makeChoice(relationalOperators); // picks an operator
		conditionParts[2] = getIntOrVariable(); // picks another int or var
		return conditionParts;
	}
	private Statement[] makeBody() {
		//creates an array of statements of a size of 0-10 
		int size = random.nextInt(10);
		Statement[] statements = new Statement[size];
		// limit Statements to Assignments and MethodCalls

		for (int i = 0; i < size; i++) {
			int option = random.nextInt(2);
			if (option == 0) {
				statements[i] = makeAssignment();
			}
			else {
				statements[i] = makeMethodCall();
			}
		}
		return statements;
	}

	public Assignment makeAssignment() {
		//constructs and returns a new Assignment object with a randomly generated variable name and expression from their respective helper methods

		Assignment a1 = null;
		try {
			a1 = new Assignment(makeChoice(variables), makeExpression());
		}
		catch (InvalidStatementException e) {
			System.out.println("could not construct Assignment object");
			a1 = null;
		}
		return a1;
	}

	public MethodCall makeMethodCall() {
		//constructs and returns a new Methodcall object with a randomly generated name and argument from their respective helper methods
		//methodNames is a final array, containing a list of names of methods to be chosen from

		MethodCall mc = null;
		try {
			mc = new MethodCall(makeChoice(methodNames), makeArguments());
		}
		catch (InvalidStatementException e) {
			System.out.println("could not construct MethodCall object");
			mc = null;
		}
		return mc;
	}

	
	public Conditional makeConditional() {
		//constructs and returns a new Conditional object with a randomly generated condition and body from their respective helper methods
		// uniquely, method also includes an else statement part, which is generated the same way as the other body parts
		Conditional cond = null;
		try {
			String[] testCond = makeTestCondition();
			Statement[] thenPart = makeBody();
			Statement[] elsePart = makeBody();
			cond = new Conditional(testCond, thenPart, elsePart);
		}
		catch (InvalidStatementException e) {
			System.out.println("Could not construct Conditional object");
			cond = null;
		}
		return cond;
	}

	public WhileLoop makeWhileLoop() {
		//constructs and returns a new whileloop object with a randomly generated condition and body from their respective helper methods
		WhileLoop wl = null;
		try {
			String[] conditionParts = makeTestCondition();
			Statement[] statements = makeBody();
			wl = new WhileLoop(conditionParts, statements);
		}
		catch (InvalidStatementException e) {
			System.out.println("Could not construct WhileLoop object");
			wl = null;
		}
		return wl;
	}

	public Statement makeStatement() {
		//this method randomly chooses one of the other 4 types of statements to generate, utilizing  a switch statement 
		Statement st = null;
		int choice = 0;
	switch(choice =random.nextInt(4)){

		case(0):
		st = makeAssignment();
		break;

		case(1):
		st = makeConditional();
		break;

		case(2):
		st = makeMethodCall();
		break;

		case(3):
		st = makeWhileLoop();
		break;

	}

		return st; 
	}

	public static void main(String[] args) {
		RandomProgrammer rp = new RandomProgrammer();
		// Assignment a2 = null;
		// a2 = rp.makeAssignment();
		// System.out.println(a2);
		// MethodCall mc1 = rp.makeMethodCall();
		// System.out.println(mc1);
		// WhileLoop wl1 = rp.makeWhileLoop();
		// System.out.println(wl1);
		Conditional cond1 = rp.makeConditional();
		System.out.println(cond1);
		// Statement statement = rp.makeStatement();
		// System.out.println(statement); 
	}
}

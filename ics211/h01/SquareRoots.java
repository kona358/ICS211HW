package edu.ics211.h01;

public class SquareRoots {

    public static double[] squareRoots(int max) {
        //ensures the input is valid
    	if(max<2){
        	System.out.println("invalid input");
          return new double[] {-1.0};
        }
    	// creates a new array for the square root values to be added to
        double[] roots;
        //inits the array to have a certain size based on the input and 
        //so we use the proper variable for the for loop
        int size = max-1;
        roots = new double[size];

        for(int i = 0; i<size; i++){
        
          roots[i] = Math.pow(i+2, 1.0/2);
        }
          return roots;
      }

}

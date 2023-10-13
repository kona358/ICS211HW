package edu.ics211.h01;
import java.io.File;
import java.io.FileNotFoundException;
public class HW1 {


public static void main(String[] args) throws FileNotFoundException {
    // need to generate an integer between 0 and 10
    int num = (int) (11 * Math.random());
    System.out.println("num is " + num);
    
    double[] values = SquareRoots.squareRoots(num);
    //prints the array values if the array is valid
    if (values[0] != -1.0) {
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i]);
            if (i < values.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("");
    }
    //prints the name of a file (from the argument)and prints the character count from the method
    for (String arg : args) {
        System.out.println(arg +" " +FileReader.getCharInFile(arg));
    }


		}

	}


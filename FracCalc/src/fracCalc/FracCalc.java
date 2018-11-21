package fracCalc;
import java.util.*;
public class FracCalc {

    public static void main(String[] args) 
    {
    	Scanner console = new Scanner(System.in);
    	boolean done = false;
    	System.out.println("Pleace print an expression with two operands.");
    	String input = console.nextLine();
    	while (done!=true) {
    		//later try !answer.equals(quit)
    		System.out.println(produceAnswer(input));
    		System.out.println("Type \"quit\" to end or new values to try again.");
    		input = console.nextLine();
    		if (input.equals("quit")) {
    			done=true;
    		}
    	}
    		
    }
    public static String produceAnswer(String input) {
    	String[] splitted = input.split(" ");
    	String operand1 = splitted[0];
    	String operator = splitted[1];
    	String operand2 = splitted[2];
    	String answer1 = stringToImproperFrac(operand1);
    	String answer2 = stringToImproperFrac(operand2);
    	return (answer2);
    }
    
    public static String stringToImproperFrac(String s) {
    	String[] mixednumcomponents = s.split("_");
    	//for later: int wholenumber = Integer.parseInt(mixednumcomponents[0]);
    	int wholenumber = 0;
    	int numerator = 0;
    	int denominator = 1;
    	if (mixednumcomponents.length>1) {
	    	wholenumber = Integer.parseInt(mixednumcomponents[0]);
	    	String[] fraction = mixednumcomponents[1].split("/");
	    	numerator = Integer.parseInt(fraction[0]);
	    	denominator = Integer.parseInt(fraction[1]);
    	}
    	else {
    		wholenumber = 0;
	    	String[] fraction = s.split("/");
	    	if (fraction.length>1) {
	    		numerator = Integer.parseInt(fraction[0]);
	    		denominator = Integer.parseInt(fraction[1]);
	    	}
	    	else {
	    		wholenumber = Integer.parseInt(fraction[0]);
	    	}
    	}
    	return("whole:"+wholenumber+" numerator:"+numerator+" denominator:"+denominator);
    }
    
    public static String toImproperFrac(int wholenumber, int numerator, int denominator) {
		//converts mixed number to improper fraction using math rules
		if (denominator == 0) {
			throw new IllegalArgumentException("The denominator is 0, please give the right input.");
		}
		int answer = wholenumber*denominator+numerator;
		return (answer+"/"+denominator);
	}
	public static String toMixedNum(int numerator, int denominator) {
		//converts an improper fraction to mixed number using math rules
		if (denominator == 0) {
			throw new IllegalArgumentException("The denominator is 0, please give the right input.");
		}
		int wholenumber = numerator/denominator;
		//whole number is the result of division where the remainder is ignored
		if (wholenumber==0) {
			return ("That's not an improper fraction, your answer is "+numerator+"/"+denominator);
			//if the numerator is not greater than the denominator, returns error above
		}
		else {
			int remainder = numerator%denominator;
			//remainder uses mod (%) which gives only the remainder when dividing
			return (wholenumber+"_"+remainder+"/"+denominator);
		}
	}
    
    
    
    
    
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"

    // TODO: Fill in the space below with any helper methods that you think you will need
}

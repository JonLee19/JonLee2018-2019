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
    	int[] operand1 = stringToImproperFrac(splitted[0]);
    	String operator = splitted[1];
    	int[] operand2 = stringToImproperFrac(splitted[2]);
    	int[] answer = new int[2];
    	if (operator.equals("-")||operator.equals("+")) {
    		if (operator.equals("-")) {
    			operand2[0]=-operand2[0];
    		}
    		answer[0] = operand1[0]*operand2[1]+operand2[0]*operand1[1];
    		answer[1] = operand1[1]*operand2[1];
    		//cross multiply the numerators by the other operand's denominator
    		//and then add to get your final answer's numerator
    	}
    	else {
    		if (operator.equals("/")) {
    			operand2[0]=operand2[1];
    			//division is the same as multiplication by the reciprocal
    		}
    		answer[0] = operand1[0]*operand2[0];
    		answer[1] = operand1[1]*operand2[1];
    		//multiply numerators and denominators in fraction multiplication
    	}
    	return Arrays.toString(answer);
    }
    
    public static int[] stringToImproperFrac(String s) {
    	String[] mixednumcomponents = s.split("_");
    	//for later: int wholenumber = Integer.parseInt(mixednumcomponents[0]);
    	int wholenumber = 0;
    	int numerator = 0;
    	int denominator = 1;
    	if (mixednumcomponents.length>1) {
    		//if there are 2 or more components after splitting on _, that means there was
    		//a whole number and a fractional component
	    	wholenumber = Integer.parseInt(mixednumcomponents[0]);
	    	String[] fraction = mixednumcomponents[1].split("/");
	    	numerator = Integer.parseInt(fraction[0]);
	    	denominator = Integer.parseInt(fraction[1]);
	    	//after splitting further on /, assign each value to their respective parts
    	}
    	else {
    		//if splitting on _ produces only one component, there is no whole
    		//number, so set wholenumber to 0
    		wholenumber = 0;
	    	String[] fraction = s.split("/");
	    	if (fraction.length>1) {
	    		//if splitting on / produces more than one component, assign each 
	    		//value to its respective part of the fraction
	    		numerator = Integer.parseInt(fraction[0]);
	    		denominator = Integer.parseInt(fraction[1]);
	    	}
	    	else {
	    		//if splitting on _ and / both produce only one component, that
	    		//value must be a whole number with no fractional components
	    		wholenumber = Integer.parseInt(fraction[0]);
	    	}
    	}
    	return toImproperFrac(wholenumber,numerator,denominator);
    }
    
    public static int[] toImproperFrac(int wholenumber, int numerator, int denominator) {
		//converts mixed number to improper fraction using math rules
		if (denominator == 0) {
			throw new IllegalArgumentException("The denominator is 0, please give the right input.");
		}
		int answer = wholenumber*denominator+numerator;
		int[] improperfrac = {answer, denominator};
		return improperfrac;
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
	public static int gcf(int num1, int num2) {
		//finds the largest factor shared by both given values
		int answer = 1;
		for (int i = (int) absValue(num1); i > 1; i--) {
			/*starting from the 1st input (either works), count down while testing factors
			 * to see if both num1 and num2 are divisible by them
			 */
			if (isDivisibleBy(num1,i)==true && isDivisibleBy(num2,i)==true) {
					answer = i;
					i = 1;
					/*once a factor is found, assign the value to answer, then
					 * set the control variable/counter to 1 to end the loop
					 *  (so that "i" doesn't satisfy the test condition anymore)
					 */
			}
		}
		return answer;
	}
	public static boolean isDivisibleBy(int dividend, int divisor) {
		//if dividend divided by divisor has no remainder, it is divisible 
		//so returns true, if not, returns false
		if (divisor == 0) {
			throw new IllegalArgumentException("The given divisor is 0, please give the right input.");
			//return error message if incorrect input is given
		}
		else {
			if (dividend%divisor == 0) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	public static double absValue(double number) {
		//if number is negative, returns the opposite; 
		//if number is positive, returns number
		//either result is the positive value of number
		if (number <= 0) {
			return -1*number;
		}
		else {
			return number;
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

package fracCalc;
import java.util.*;
public class FracCalc {

    public static void main(String[] args) {
    	Scanner console = new Scanner(System.in);
    	boolean done = false;
    	System.out.println("Pleace print an expression with two operands.");
    	String input = console.nextLine();
    	//open scanner to take in an expression
    	while (done!=true) {
    		//later try !answer.equals(quit)
    		System.out.println(produceAnswer(input));
    		System.out.println("Type \"quit\" to end or new values to try again.");
    		input = console.nextLine();
    		if (input.equals("quit")) {
    			done=true;
    		}
    	}
    	console.close();	
    }
    public static String produceAnswer(String input) {
    	String[] splitted = input.split(" ");
    	int[] answer = stringToImproperFrac(splitted[0]);
    	//split on a space to separate the operands and operators
    	for (int i = 2; i<splitted.length; i+=2) {
    		String operator = splitted[i-1];
    		//operators are every other array element after splitting on " "
	    	if (!(operator.equals("+")||operator.equals("-")||operator.equals("*")||operator.equals("/"))) {
	    		return ("ERROR: Input is in an invalid format.");
	    	}
	    	//if operator is not one of the 4 basic operations, return error
    		int[] operand2 = stringToImproperFrac(splitted[i]);
    		//update operand2 to the next operand, which is every other array element
    		answer = doMath(answer, operator, operand2);
    		//produce a new result from each successive operation, storing it in answer
    	} 
		if (answer[1]==0) {
    		return("ERROR: Cannot divide by zero.");
    	}
		/*if one operand's denominator is 0, the final fraction's denominator will also be 0
	     *because the only math performed on the denominator is multiplication
		 *and dividing by zero is not allowed for this calculator, so return error
		 */
		return toMixedNum(answer[0], answer[1]);
    }
    public static int[] doMath(int[] answer, String operator, int[] operand2) {
    	if (operator.equals("-")||operator.equals("+")) {
    		if (operator.equals("-")) {
    			operand2[0]=-operand2[0];
    		}
    		//subtraction is just adding by the negative of the second operand
    		answer[0] = answer[0]*operand2[1]+operand2[0]*answer[1];
    		answer[1] = answer[1]*operand2[1];
    		//cross multiply the numerators by the other operand's denominator
    		//and then add to get your final answer's numerator
    	}
    	else {
    		if (operator.equals("/")) {
    			int temp=operand2[1];
    			operand2[1]=operand2[0];
    			operand2[0]=temp;
    			//division is the same as multiplication by the reciprocal of the second operand
    		}
    		answer[0] = answer[0]*operand2[0];
    		answer[1] = answer[1]*operand2[1];
    		//multiply numerators and denominators in fraction multiplication
    	}
    	
    	int gcf = gcf(answer[0], answer[1]);
    	answer[0] = answer[0]/gcf;
    	answer[1] = answer[1]/gcf;
    	return answer;
    	//find gcf of numerator and denominator of answer, reduce the fraction by dividing 
    	//both components by that gcf, and then return as a mixed number
    }
    
    public static int[] stringToImproperFrac(String s) {
    	//convert operands to improper fractions where the components make up an array
    	String[] mixednumcomponents = s.split("_");
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
		if (wholenumber<0) {
			numerator=-numerator;
		}
		//if the fraction is negative, numerator needs to be negative to "add" it to whole number
		//when converting to an improper fraction
		int impropernumerator = wholenumber*denominator+numerator;
		//convert whole number to the appropriate fraction and then add to numerator to produce the improper numerator
		int[] improperfrac = {impropernumerator, denominator};
		//return an array made of the final numerator and denominator
		return improperfrac;
	}
	public static String toMixedNum(int numerator, int denominator) {
		//converts an improper fraction to mixed number using math rules
		if (numerator==0) {
			return ("0");
		}
		//if numerator is 0, that means the fraction is equal to 0
		int wholenumber = numerator/denominator;
		//whole number is the result of division where the remainder is ignored
		if (wholenumber==0) {
			if (denominator<0) {
				numerator=-numerator;
				denominator=-denominator;
				//switches the negative to the numerator, because denominators can't have negative signs
			}
			return (numerator+"/"+denominator);
			//if the numerator is not greater in absolute value than the denominator, returns original fraction
		}
		int remainder = absValue(numerator%denominator);
		denominator =  absValue(denominator);
		/*remainder uses mod (%) which gives only the remainder when dividing
		 *now that all division has been completed, convert denominator to a positive
		 *because denominators of fractions are always written as positives
		 */
		if (remainder==0) {
			return (""+wholenumber);
		}
		//if no remainder, then the numerator divides evenly and there is no fractional component
		return (wholenumber+"_"+remainder+"/"+denominator);
		//return mixed number as a string
	}
	public static int gcf(int num1, int num2) {
		//finds the largest factor shared by both given values
		int answer = 1;
		for (int i = absValue(num1); i > 1; i--) {
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
	public static int absValue(int number) {
		if (number <= 0) {
			return -1*number;
			//if number is negative, returns the opposite;
		}
		else {
			return number;
			//if number is positive, returns number
		}
		//either result is the positive value of number
	}
	/* a second method using 2D arrays:
    public static String produceAnswer(String input) {
    	String[] splitted = input.split(" ");
    	int[][] operand = new int[splitted.length/2+1][3];
    	for (int i = 0; i<splitted.length; i++) {
	    	operand[i] = stringToImproperFrac(splitted[2(i)]);
	    	String operator = splitted[2(i+1)];
	    	//split on a space to separate the operands and operator, and then 
	    	//convert operands to improper fractions where the components make up an array
    	}
    	if (operator.equals("+")||operator.equals("-")||operator.equals("*")||operator.equals("/")) {
    		return ("ERROR: Input is in an invalid format.");
    	}
    	int[] answer = new int[2];
    	if (operator.equals("-")||operator.equals("+")) {
    		if (operator.equals("-")) {
    			operand2[0]=-operand2[0];
    		}
    		//subtraction is just adding by the negative of the second operand
    		answer[0] = operand1[0]*operand2[1]+operand2[0]*operand1[1];
    		answer[1] = operand1[1]*operand2[1];
    		//cross multiply the numerators by the other operand's denominator
    		//and then add to get your final answer's numerator
    	}
    	else {
    		if (operator.equals("/")) {
    			int temp=operand2[1];
    			operand2[1]=operand2[0];
    			operand2[0]=temp;
    			//division is the same as multiplication by the reciprocal of the second operand
    		}
    		answer[0] = operand1[0]*operand2[0];
    		answer[1] = operand1[1]*operand2[1];
    		//multiply numerators and denominators in fraction multiplication
    	}
    	if (answer[1]==0) {
    		return("ERROR: Cannot divide by zero.");
    	}
    	int gcf = gcf(answer[0], answer[1]);
    	answer[0] = answer[0]/gcf;
    	answer[1] = answer[1]/gcf;
    	return toMixedNum(answer[0], answer[1]);
    	//find gcf of numerator and denominator of answer, reduce the fraction by dividing 
    	//both components by that gcf, and then return as a mixed number
    }
    */
}

//This class contains methods that perform various math operations
//@author Jon Lee
//@version October 29, 2018
import java.util.*;
public class Split {
	 public static void main(String[] args) {

	// Your task Part 0

	//String.split();

	//It's a method that acts on a string, <StringName>.split(<String sp>);

	//Where sp is the string where the string splits

	//And it returns an array

	System.out.println(Arrays.toString("I like apples!".split(" ")));

	// it will split at spaces and return an array of ["I","like","apples!"]

	System.out.println(Arrays.toString("I really like really red apples".split("really")));

	// it will split at the word "really" and return an array of ["I "," like ","red apples!"]

	//play around with String.split!

	//What happens if you "I reallyreally likeapples".split("really") ?
	System.out.println(Arrays.toString("I reallyreally likeapples".split("really")));
	
	//Your task Part 1:

	/*Write a method that take in a string like

	* "applespineapplesbreadlettustomatobaconmayohambreadcheese"

	* describing a sandwich.

	* Use String.split to split up the sandwich by the word "bread" and return what's in the middle of

	* the sandwich and ignores what's on the outside

	* What if it's a fancy sandwich with multiple pieces of bread?

	*/
	
	//int firstbread = input.indexOf("bread");
	//int lastbread = input.length()-1;
	/*for (int i=input.length()-1; i>0; i--) {
		if (input.substring(i,i+4).equals("bread")) {
			lastbread = i;
		}
	}
	*/
	String input1 = "breadapplespineapplesbreadlettucetomatobaconmayohambreadcheese";
	System.out.println(sandwhichSplitter(input1));
	//Your task pt 2:

	//Write a method that take in a string like

	 String input2 = "apples pineapples bread lettuce tomato bacon mayo ham bread cheese bread";
	 System.out.println(sandwhichSplitter(input2));
	
	//String splitup = Arrays.toString(input.split(" "));
	

	/* describing a sandwich

	* use String.split to split up the sandwich at the spaces, " ", and return what's in the middle of

	* the sandwich and ignores what's on the outside.

	* Again, what if it's a fancy sandwich with multiple pieces of bread?

	*/

	 }
	 String input = "applespineapplesbreadlettucetomatobaconmayohambreadcheese";
		public static String sandwhichSplitter(String input) {
			int breadcount = 0;
			//create variable breadcount
			int firstbread = input.indexOf("bread");
			//finds first occurrence of bread
			int lastbread = 0;
			//initialize variables to find the last occurrence of bread
			for (int i=0; i<input.length()-4; i++) {
				if (input.substring(i,i+5).equals("bread")) {
					breadcount++;
					lastbread = i;
					//traversing the string, count the number of breads,
					//and also set lastbread to the index of the first letter
					//in the final instance of bread
				}
			}
			if (breadcount<=2) {
				throw new IllegalArgumentException("There is no inner bread. Please give me a better sandwhich.");
			}
			String[] array = input.split("bread");
			//split array based on bread
			//System.out.println(firstbread+4);
			//System.out.println(lastbread-(5*(breadcount-2)));
			//used for troubleshooting
			return((Arrays.toString(array)).substring(firstbread+6-breadcount, lastbread-(5*(breadcount-2))));
			//Converts Array to String, then returns a substring 
			//from that String with the indexes of the first and last breads
			//the exact numbers used to create the substring are adjusted
			//because the Arrays.toString adds ", "
		}
		
}



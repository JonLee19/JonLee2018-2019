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
	

	//Your task pt 2:

	//Write a method that take in a string like

	 String input2 = "apples pineapples bread lettuce tomato bacon mayo ham bread cheese";
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
			int lastbread = 0;
			for (int i=0; i<input.length()-4; i++) {
				if (input.substring(i,i+5).equals("bread")) {
					breadcount++;
					lastbread = i;
					//System.out.println(breadcount);
				}
			}
			int firstbread = input.indexOf("bread");
			//System.out.println(firstbread);
			String[] array = input.split("bread");
			//System.out.println(Arrays.toString(array));
			return((Arrays.toString(array)).substring(firstbread+3, lastbread-2));
			//because the Arrays.toString adds ", "
			//System.out.println((array[1]);
		}
}



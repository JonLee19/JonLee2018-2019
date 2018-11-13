//This class contains methods that complete the Arrays Lab 3
//@author Jon Lee
//@version November 8, 2018
import java.util.Arrays;

public class ArraysLab3 {
	
	public static void main(String[] args) {
		int[] a1 = {5, 10, 15, 20, 25, 30, 35, 40};
		int[] a2 = {7, 14, 21, 28, 35, 42, 49, 56};
		int[] sumArr = sum(a1, a2);
		int appendNum=200;
		int[] appendArr = append(a1, appendNum);
		int removeIdx = 5;
		int[] removeArr = remove(a2,removeIdx);
		int sumOfEvens = sumEven(appendArr);
		rotateRight(a1);
		System.out.println(Arrays.toString(sumArr));
		System.out.println(Arrays.toString(appendArr));
		System.out.println(Arrays.toString(removeArr));
		System.out.println(sumOfEvens);
		System.out.println(Arrays.toString(a1));
	}
	public static int[] sum(int[] arr1, int[] arr2) {
		int[] finalarray = new int[arr1.length];
		for(int i =0; i< finalarray.length; i++) {
			finalarray[i] = arr1[i] + arr2[i];
		}
		return(finalarray);
	}
	public static int[] append(int[] arr, int num) {
		int[] finalarray = new int[arr.length+1];
		for(int i =0; i< arr.length; i++) {
			finalarray[i] = arr[i];
		}
		finalarray[arr.length] = num;
		return(finalarray);
	}
	public static int[] remove(int[] arr, int idx) {
		int counter= 0;
		int[] finalarray = new int[arr.length-1];
		for(int i =0; i< finalarray.length; i++) {
			if (i==idx) {
				counter++;
			}
			else {
				finalarray[i] = arr[i+counter];
			}
		}
		return(finalarray);
	}
	public static int sumEven(int[] arr) {
		int sum=0;
		for(int i =0; i< arr.length; i+=2) {
			sum+=arr[i];
		}
		return(sum);
	}
	public static void rotateRight(int[] arr) {
		int k = arr[arr.length-1];
		for(int i=arr.length-1; i>0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = k;
	}
}
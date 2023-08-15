package seven;
import java.util.Random;
import java.util.Scanner;
//Ethan Michalsky
//Started 2022-9-13
//Ended 2022-9-13
//Copyright 2022, Ethan Michalsky. All rights reserved.
public class Linear {
	static Scanner aa = new Scanner(System.in);
	public static void main(String[] args) {
		Random rad = new Random();
		String imp = "";
		int search;
		int[] stack = new int[20];
		System.out.println("What number would you like to search for from 0 to 20?");
		System.out.println("Or would you like a random number?");
		imp = aa.nextLine();
		//if the input contains random number then randomizes the search number
		//if not then changes the string into an integer
		if (imp.contains("r") || imp.contains("n") || imp.contains("a") || imp.contains("b") || imp.contains("m")) {
			search = rad.nextInt(20);
		}
		else {
			search = Integer.parseInt(imp);
		}
		//Randomizes the contents of the array
		for (int i = 0; i < stack.length; i++) {
			stack[i] = rad.nextInt(20);
			meth.showArr(stack);
		}
		//Linear searches for the an integer in the array
		int find = linSearch(stack, search);
		if (find == -1) {
			System.out.println(search + " Has not been found in the Array");
		}
		else {
			System.out.println(search + " Has been found at index " + find);
		}
	}
	
	private static int linSearch(int[] stack, int search) {
		//assume the number has not been found
		int ind = -1;
		//Searches through the array until number has been found or till the end of the array
		for (int i = 0; i < stack.length; i++) {
			if (stack[i] == search) {
				ind = i;
				break;
			}
		}
		//returns the index where the number is found, -1 if not found
		return ind;
	}
}

package seven;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
//Ethan Michalsky
//Started 2022-9-7
//Ended 2022-9-8
//Copyright 2022, Ethan Michalsky. All rights reserved.
@SuppressWarnings("unused")
public class warmup {
	static Scanner aa = new Scanner(System.in);
	static int[] yes = new int[1];
	static Random ran = new Random();
	public static void main(String[] args) {
		boolean done = false;
		String input = "";
		while (!done) {
			 System.out.println("1. Size the array");
			 System.out.println("2. Fill the array with random (and possibly duplicate) values");
			 System.out.println("3. Sort the array");
			 System.out.println("4. Scramble the array");
			 System.out.println("5. Print the array");
			 System.out.println("6. Search the array for a value");
			 System.out.println("7. Count occurances of a value in the array");
			 System.out.println("8. Fill the array with unique (no duplicates) random values");
			 System.out.println("9. Remove a number from the Array");
			 System.out.println("10. Quit");
			 //takes input for what user wants to do
			 input = aa.nextLine();
			 if (input.equals("1")) {
				 resizeArr();
			 }
			 else if (input.equals("2")) {
				 filRan();
			 } 
			 else if (input.equals("3")) {
			     Arrays.sort(yes);
			 }
			 else if (input.equals("4")) {
			     scrambleArr();
			 } 
			 else if (input.equals("5")) {
			     printArr();
			 } 
			 else if (input.equals("6")) {
			     searchArr();
			 } 
			 else if (input.equals("7")) {
			     countArr();
			 } 
			 else if (input.equals("8")) {
			     fillUni();
			 }
			 else if (input.equals("9")) {
				 removeCont();
			 }
			 else if (input.equals("10")) {
				 done = true;
			 }
		}
		System.out.println("See you later!");
	}
	// Sizing the array
	public static void resizeArr() {
		System.out.println("How big do you want the Array?");
		int size = Integer.parseInt(aa.nextLine());
		yes = new int[size];
	}
	//fills the array with random numbers
	public static void filRan() {
		for (int i = 0; i < yes.length; i++) {
			yes[i] = ran.nextInt(yes.length + 1);
		}
	}
	//prints in the console the array
	public static void printArr() {
		System.out.println(Arrays.toString(yes));
	}
	//scrambles the numbers in the array
	public static void scrambleArr() {
		for (int i = 0; i < yes.length; i++) {
			int temp = yes[i];
			int index = ran.nextInt(yes.length);
			yes[i] = yes[index];
			yes[index] = temp;
		}
	}
	//searches the array for a value
	public static void searchArr() {
		System.out.println("Enter the value you want to seatch");
		int value = Integer.parseInt(aa.nextLine());
		int index = -1;
		for (int i = 0; i < yes.length; i++) {
			if (yes[i] == value) {
				index = i;
				break;
			}
		}
	}
	//counts how many times a value exist in the array
	public static void countArr() {
		System.out.println("Enter the value you want to count");
		int value = Integer.parseInt(aa.nextLine());
		int count = 0;
		for (int i = 0; i < yes.length; i++)	{
			if (yes[i] == value) {
				count++;
			}
		}
		System.out.println("There is: " + count + " times it is there");
	}
	//fills the array with non dublicate numbers
	public static void fillUni() {
		for (int i = 0; i < yes.length; i++) {
			yes[i] = i + 1;
		}
		scrambleArr();
	}
	//removes a number using a index from the array
	public static void removeCont() {
		System.out.println("What index number do you want to remove? (0 to " + yes.length + ")");
		int index = Integer.parseInt(aa.nextLine());
		for (int y = index; y < yes.length -1; y++) {
		    yes[y] = yes[y + 1];
		}
	}
}

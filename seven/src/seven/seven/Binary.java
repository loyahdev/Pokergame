package seven;
import java.util.Random;
//Ethan Michalsky
//Started 2022-9-12
//Ended 2022-9-13
//Copyright 2022, Ethan Michalsky. All rights reserved.
public class Binary {

	public static void main(String[] args) {
		Random rad = new Random();
		int[] stack = new int[67];
		int needle = rad.nextInt(67) + 1;
		
		for (int i = 0; i < stack.length; i++) {
			stack[i] = rad.nextInt(67) + 1;
		}
		//Using another java class that has the three sorting methods to sort and a method that shows the array.
		meth.Selection(stack);
		meth.showArr(stack);
		
		int index = binSearch(stack, needle);
		if (index == -1) {
			System.out.println(needle + " has not been found");
		}
		else {
			System.out.println(needle + " has been found at index " + index);
		}
	}

	private static int binSearch(int[] stack, int needle) {
		//Boundaries
		int low = 0;
		int upper = stack.length;
		//Repeat till the integers are the same
		while(low <= upper) {
			//Finding middle index
			int mid = (upper + low) /2;
			//If Int needle is found than return
			if (stack[mid] == needle) {
				return mid;
			}
			//If the int is smaller shift upper bounds
			else if (stack[mid] > needle) {
				upper = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
		return -1;
	}
}

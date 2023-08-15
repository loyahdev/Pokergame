package seven;

//Ethan Michalsky
//Copyright 2022, Ethan Michalsky. All rights reserved.

//how to call the method

//B.java
//class B {
//	public static void imagine() {
//		yes
//	}
//}

//A.java
//class A {
//    public void imaginge() {
//         B.imagine(); // calls B.java's class method
//    }
//}

//Currently has
//Print Array
//Bubble Sort
//Selection Sort
//Insertion Sort
//Binary Search
//Linear Search
//Merge Array's
public class meth {
	
	public static void showArr(int[] list) {
		//Prints every number in the array
		int dex = 0;
		for (int n : list) {
			System.out.print(n + " ");
			dex++;
			if (dex % 20 == 0) {
				if (dex == 1) {
					
				}
				else {
					System.out.println();
				}
			}
		}
		System.out.println();
	}
	
	public static void Insertion(int arr[]) {
		//Goes through the array to the smallest number, then places it after a smaller number or at the beginning
		for (int i = 1; i < arr.length; i++) {
			int index = arr[i];
			int j = i -1;
			while (j >= 0 && arr[j] > index) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = index;
		}
	}
	
	public static void bubble(int sort[]) {
		if (sort.length > 1) {
			boolean sorted = false;
			do {
				showArr(sort);
				sorted = true;
				for (int i = 0; i < sort.length - 1; i++) {
					if (sort[i] > sort[i + 1]) {
						int tmp = sort[i];
						sort[i] = sort[i + 1];
						sort[i + 1] = tmp;
						sorted = false;
					}
				}
			}
			while (!sorted);
		}
	}
	
	public static void Selection(int sort[]) {
		for (int i = 0; i < sort.length - 1; i++) {
			int smallest = i;
			for (int j = i + 1; j < sort.length; j++) {
				if (sort[j] < sort[smallest]) {
					smallest = j;
				}
			}
			
			if (i != smallest) {
				int tmp = sort[i];
				sort[i] = sort[smallest];
				sort[smallest] = tmp;
			}
		}
	}
	
	public static int binSearch(int[] stack, int needle) {
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
			//Int is higher than the middle shifts the bounds up
			else {
				low = mid + 1;
			}
		}
		return -1;
	}
	
	public static int linSearch(int[] stack, int search) {
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
	
	public static int[] merge (int[] flist, int[] sif) {
		int[] merged = new int[flist.length + sif.length];
		int dex = 0;
		int str = 0;
		
		while (dex < flist.length && str < sif.length) {
			if (flist[dex] <= sif[str]) {
				merged[dex + str] = flist[dex];
				dex++;
			}
			else {
				merged[dex + str] = sif[str];
				str++;
			}
		}
		if (dex < flist.length) {
			for (int i = dex + str; i < merged.length; i++) {
				merged[i] = flist[dex];
				dex++;
			}
		}
		else {
			for (int i = dex + str; i < merged.length; i++) {
				merged[i] = sif[str];
				str++;
			}
		}
		return merged;
	}
	
}
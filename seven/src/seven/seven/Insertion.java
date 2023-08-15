
//Ethan Michalsky
//Started 2022-9-12
//Ended 2022-9-12
//Copyright 2021, Ethan Michalsky. All rights reserved.
public class Insertion {

	public static void main(String[] args) {
		int[] sort = {2, 6, 8, 1, 23, 5, 9, -2, 34, 82, -12, 28, 0, 82, -62, 97};
		sorting(sort);
		showArray(sort);
	}
	
	public static void sorting(int arr[]) {
		for (int i = 1; i < arr.length; i++) {
			int index = arr[i];
			int j = i -1;
			
			while (j >= 0 && arr[j] > index) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = index;
			showArray(arr);
		}
	}
	
	public static void showArray(int[] list) {
		for (int n : list) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
}

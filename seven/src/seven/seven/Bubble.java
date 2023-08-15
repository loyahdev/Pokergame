package seven;
//Ethan Michalsky
//Started 2022-9-12
//Ended 2022-9-12
//Copyright 2021, Ethan Michalsky. All rights reserved.
public class Bubble {
	public static void main(String[] args) {
		int[] sort = {2, 6, 8, 1, 23, 5, 9, -2};
		if (sort.length > 1) {
			boolean sorted = false;
			do {
				showArray(sort);
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
		showArray(sort);
	}
	
	public static void showArray(int[] list) {
		for (int n : list) {
			System.out.print(n + " ");
		}
		System.out.println();
	}

}

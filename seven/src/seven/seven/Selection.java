package seven;
//Ethan Michalsky
//Started 2022-9-12
//Ended 2022-9-12
//Copyright 2021, Ethan Michalsky. All rights reserved.
public class Selection {
	public static void main(String[] args) {
		int sort[] = {34, 82, -12, 28, 0, 82, -62, 97};
		showArray(sort);
		
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
			showArray(sort);
		}
	}
	public static void showArray(int[] list) {
		for (int n : list) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
}

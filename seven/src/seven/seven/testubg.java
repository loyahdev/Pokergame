package seven;
import java.util.Scanner;

public class testubg {
	
	static Scanner aa = new Scanner(System.in);
	
	public static void main(String[] args) {
		int[] arr = new int[10];
		int a = 0;
		for (int i = 0; i < arr.length; i++) {
			a = aa.nextInt();
			arr[i] = a;
		}
		meth.showArr(arr);
		meth.bubble(arr);
	}
	
}

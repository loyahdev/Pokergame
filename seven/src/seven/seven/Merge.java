package seven;
import java.util.Arrays;
import java.util.Random;
//Ethan Michalsky
//Started 2022-9-19
//Ended 2022-9-19
//Copyright 2022, Ethan Michalsky. All rights reserved.
public class Merge {

	public static void main(String[] args) {
		Random rad = new Random();
		int[] flist = new int[7];
		for (int i = 0; i < flist.length; i++) {
			flist[i] = rad.nextInt(50);
		}
		int[] sif = new int[5];
		for (int i = 0; i < sif.length; i++) {
			sif[i] = rad.nextInt(50);
		}
		meth.Insertion(flist);
		meth.Insertion(sif);
		meth.showArr(flist);
		meth.showArr(sif);
		
		int[] merged = merge (flist, sif);
		meth.showArr(merged);
	}
	
	private static int[] merge (int[] flist, int[] sif) {
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

package Practice;

import java.util.Arrays;

public class DuplivatValue {
	public static void main(String[] args) {
		int i = 0;
		//int count=0;
		int[] array = { 4, 3, 6, 4, 2, 7, 8, 9, 6, 7, 8, 9 };
		for (i = 0; i < array.length; i++) {
         int count=0;
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) {
					count++;
				}
			}
			if(count!=0) {
			System.out.println("  " + array[i] + " is duplicated " + count+ " times");
			}else
	       	System.out.println("Number is Unique: " +array[i]);		
		}
		// System.out.println(Arrays.toString(array));
	}
}

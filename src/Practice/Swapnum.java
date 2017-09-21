package Practice;

import java.util.Arrays;

public class Swapnum {
	public static void main(String [] args) {
		int[] array= {2,5,3,1,8};
		int[] array1= {4,6,5,2,6};
		
		int temp=array[3];
		array[3]=array[0];
		array1[0]=temp;
		
		System.out.println(Arrays.toString(array));
		System.out.println(Arrays.toString(array1));

		
		
		
	}

}

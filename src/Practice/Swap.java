package Practice;

import java.util.Arrays;

public class Swap {
public static void main(String [] args) {
	
	int []a= {1,2,3,4,5};
	int []b= {9,8,7,6};
	
	int temp=a[1];
	a[1]=b[2];
	b[2]=temp;
	System.out.println(Arrays.toString(a));
	System.out.println(Arrays.toString(b));

}
}

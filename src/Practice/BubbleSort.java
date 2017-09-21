package Practice;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String [] args)
	{
		int []arr= {5,6,32,78,1,89,4};
		int len=arr.length;
		for(int i=0;i<=len-1;i++)
		{
			for(int j=0;j<len-i-1;j++) 
			{
				
				if(arr[j]> arr[j+1])
				{
				int temp=arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=temp;
				
				}
			}
			
			
		}
		
		System.out.println(Arrays.toString(arr));
	}

}

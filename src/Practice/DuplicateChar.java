package Practice;

import java.util.Scanner;

public class DuplicateChar {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter string 1: ");
		String name=scan.nextLine();
		int count=0;
		for(int i=0;i<=name.length()-1;i++) {
			for(int j=0;j<=name.length()-1;j++) {
			if(name.charAt(i)==name.charAt(j)){
				
				count++;
			}
			}
			
			}
		
		System.out.println(count);
		}
	
		
		
		
	}
	
	
	


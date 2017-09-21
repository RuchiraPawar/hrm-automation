package Practice;

import java.text.DecimalFormat;

public class Trim {
	public static void main(String [] args) {
		String name=" Ruchira ";
		System.out.println(name.trim());
		
		double d=32.57648;
		DecimalFormat d1=new DecimalFormat("#.##");
		String a=d1.format(d);
		System.out.println("number "+d+" is formated to "+a+" number" );
		
	}
}

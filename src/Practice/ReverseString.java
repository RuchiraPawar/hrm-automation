package Practice;

public class ReverseString{
	public static void main(String [] args) {
		
		String name="MadaM";
		int len=name.length();
		String reverse= "";
		for(int i=len-1;i>=0;i--) {
			
				reverse =	reverse + name.charAt(i);
			
		}
		System.out.println(reverse);
		if(name.equals(reverse)) {
			System.out.println("String is palindrome");
			
		}
	}
	}



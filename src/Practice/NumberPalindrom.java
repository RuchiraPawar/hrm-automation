package Practice;

public class NumberPalindrom {
	
	public static void main(String[] args) {
		
		String number="343";
		int len=number.length();
		String rev="";
		for(int i=len-1;i>=0;i--) {
			
			rev=rev+number.charAt(i);
		}
		if(number.equals(rev)) {
			
			System.out.println("Number is palindrom");
		}
	}

}

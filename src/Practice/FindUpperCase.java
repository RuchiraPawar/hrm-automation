package Practice;
import java.util.Scanner;
public class FindUpperCase {
	
	public static void main(String[] args) {
		//String name="Ruchira123";
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter name: ");
		String name=scanner.nextLine();
		int countDigit=0;
		int countUpper=0;
		int countLower=0;
		for(int i=0;i<=name.length()-1;i++) {
		if(Character.isDigit(name.charAt(i))) {
			
			countDigit++;
		}else if(Character.isUpperCase(name.charAt(i))){
			
			countUpper++;
			
		}else if(Character.isLowerCase(name.charAt(i))){
			
			countLower++;
		
		}
		}
		System.out.println("Number of digits are:" +countDigit);
		System.out.println("Number of Upper case letters are:" +countUpper);
		System.out.println("Number of Lower case letters are:" +countLower);
	}

}
	

package Practice;

public class ThreeDigit {

	public static void main(String[] args) {
		
	
		long num1 =  Math.round(Math.random()*999);
		int var1 = (int) (num1 % 10);
		int var2 = (int) (num1 / 10 % 10);
		int var3 = (int) (num1 /100 % 10);
		System.out.println(num1);

		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var3);

		
		
	
	}
}

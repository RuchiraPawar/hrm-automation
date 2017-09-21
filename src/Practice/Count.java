package Practice;

public class Count {
	public static void main(String[] args) {
		int count=0;
		String name="hello world";
		for(int i=0;i<=name.length()-1;i++) {
			
			if(name.charAt(i)=='l')
				count++;
			
		}
		System.out.println(count);
		
	}
	

}

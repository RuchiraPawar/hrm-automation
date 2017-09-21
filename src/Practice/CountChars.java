package Practice;

public class CountChars {
	public static void main(String[] args) {
	
	String  name="hello world";
	int len=name.length();
	int count=0;
	for(int i=0;i<=len-1;i++) {
		
		if(name.charAt(i)=='l') {
			
			count=count+1;
			System.out.println(count);	
		}
		
	}
	
	
	}

}	
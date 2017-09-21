package Practice;

public class BooleanTrue {
	
	public static void main(String [] args) {
	boolean a=true;
	boolean b=true;
	boolean c=false;
	boolean d=mr(a,b,c);
	System.out.println(d);
	}
	public static boolean mr(boolean a,boolean b,boolean c) {
		if((a && b) || (a && c) || (b && c)) {
			return a;
		}else
			return c;
		
	}

}

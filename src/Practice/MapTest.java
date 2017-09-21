package Practice;

import java.util.HashMap;

public class MapTest {
public static void main(String[] args) {
	HashMap<Integer, String> map=new HashMap<>();
	map.put(0, "plus");
	map.put(1, "minus");
	
	String str=map.get(0);
	System.out.println(str);
	
	
}
}

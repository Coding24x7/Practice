package practice.test;

import java.util.TreeSet;

public class Test1 {
	public static void main(String args[]) {
	      String Str = new String("Aa");
	      System.out.println("Hashcode for Str :" + Str.hashCode() );
	      char[] chars = Str.toCharArray();
	      int a = chars[0] * 31;
	      int b = chars[1] * 1;
	      System.out.println(a);
	      System.out.println(b);
	      System.out.println(a+b);
	      System.out.println("*********");
	      
	      Str = new String("BB");
	      System.out.println("Hashcode for Str :" + Str.hashCode() );
	      chars = Str.toCharArray();
	      a = chars[0] * 31;
	      b = chars[1] * 1;
	      System.out.println(a);
	      System.out.println(b);
	      System.out.println(a+b);
	      System.out.println("*********");

	      Integer s_int = new Integer("-23"); 
	      
	        // Returning a hash code value for this object  
	        int hashcodevalue = s_int.hashCode(); 
	        System.out.println("Hash code Value for object = " + hashcodevalue); 

	        
	        float binVal = 0b11111111_11111111_11111111_1111011;
	        System.out.println(binVal);
	        
	        TreeSet ts = new TreeSet();
	       }
}

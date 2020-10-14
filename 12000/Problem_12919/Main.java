package Problem_12919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a = br.readLine();
		String b = br.readLine();
		
		System.out.println(isMake(a,b) ? "1" : "0");
		
	}
	public static boolean isMake(String s, String t) {
		if(s.equals(t)) return true;
		
		if(t.length() > 0) {
			if(t.charAt(0)=='B' && isMake(s, cut(reverse(t)))) return true;
			if(t.charAt(t.length()-1)=='A' && isMake(s, cut(t))) return true;			
		}
		return false;
	}
	
	
	public static String cut(String s) {
		return s.substring(0, s.length()-1);
	}
	
	public static String reverse(String s) {
		return new StringBuilder(s).reverse().toString();
	}
}

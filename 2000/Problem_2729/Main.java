package Problem_2729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		
		for(int t =1; t<=T; t++) {
			String str = br.readLine();
			String s1 = str.split(" ")[0];
			String s2 = str.split(" ")[1];
			
			System.out.println(sum(s1,s2));
		}
	}
	
	static String sum(String a, String b) {
		String answer = "0";
		if(a.length() > b.length()) {
			int c = a.length()-b.length();
			for(int i = 0; i<c;i++) b = "0" + b;
		}
		else if(a.length() < b.length()) {
			int c = b.length()-a.length();
			for(int i = 0; i<c;i++) a = "0" + a;
		}
		
		a = new StringBuilder(a).reverse().toString();
		b = new StringBuilder(b).reverse().toString();
	
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		for(int i = 0; i<a.length(); i++) {
			boolean b1 = a.charAt(i)-'0' == 1;
			boolean b2 = b.charAt(i)-'0' == 1;
			if(b1 && b2) {
				if(flag) { sb.append("1"); }
				else { sb.append("0"); }
				flag = true;
			}
			else if(b1 || b2) {
				if(flag) {
					sb.append("0");
					flag = true;
				}
				else {
					sb.append("1");
					flag = false;
				}
			}
			else {
				if(flag) { sb.append("1"); }
				else { sb.append("0"); }
				flag = false;
			}
		}
		if(flag) sb.append("1");
		
		answer = sb.reverse().toString();
		for(;answer.charAt(0) != '1' && answer.length() > 1;) {
			answer = answer.substring(1);
		}
		return answer;
	}
}

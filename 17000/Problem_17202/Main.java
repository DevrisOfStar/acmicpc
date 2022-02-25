package Problem_17202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i<a.length(); i++) {
			sb.append(a.charAt(i));
			sb.append(b.charAt(i));
		}	
		System.out.println(dp(sb.toString()));
	}
	
	public static String dp(String num) {
		if(num.length() == 2) return num;
		else {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i<num.length()-1;i++) {
				int a = num.charAt(i) - '0';
				int b = num.charAt(i+1) -'0';
				sb.append((a+b)%10);
			}
			return dp(sb.toString());
		}
	}
}

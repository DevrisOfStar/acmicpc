package Problem_10610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		String str = br.readLine();
		
		if(!str.contains("0")) {
			System.out.println(-1);
			return;
		}
		int a = 0;
		int b = -1;
		for(int i =0; i < str.length(); i++) {
			a += str.charAt(i) - '0';
		}
		
		if(a % 3 != 0) {
			System.out.println(-1);
			return;
		}
		
		char[] cs = str.toCharArray();
		Arrays.sort(cs);
		StringBuilder sb = new StringBuilder();
		for(int i = cs.length-1; i >= 0; i--) sb.append(cs[i]);

		System.out.println(sb.toString());
	}
}

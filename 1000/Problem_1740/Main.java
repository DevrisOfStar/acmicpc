package Problem_1740;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());
		long ans = 0l;
		long c = 1l;
		StringBuilder str = new StringBuilder();
		do { str.append(N%2); N/=2; } while(N > 0); // 이진수
		for(int i =0 ; i<str.length(); i++) {
			if(str.charAt(i) == '1') { ans += c; }
			c *= 3l;
		}
		System.out.println(ans);
	}
}

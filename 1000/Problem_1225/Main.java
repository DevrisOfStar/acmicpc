package Problem_1225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String a = str.split(" ")[0];
		String b = str.split(" ")[1];
		
		long answer = 0;
		for(int i = 0; i<a.length(); i++) {
			for(int j = 0; j<b.length(); j++) {
				answer += ((a.charAt(i)-'0') * (b.charAt(j)-'0'));
			}
		}
		System.out.println(answer);
	}
}

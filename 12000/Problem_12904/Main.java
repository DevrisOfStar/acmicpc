package Problem_12904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		int i = 0;
		while(str2.length() > 0) {
			if(str2.charAt(str2.length()-1) == 'A') {
				str2 = str2.substring(0, str2.length()-1);
			}
			else {
				str2 = str2.substring(0, str2.length()-1);
				StringBuilder sb = new StringBuilder(str2);
				str2 = sb.reverse().toString();
			}
			
			if(str1.equals(str2)) {
				System.out.println("1");
				return;
			}
		}
		
		System.out.println("0");
	}
}

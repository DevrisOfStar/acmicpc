package Problem_11140;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int T = Integer.parseInt(br.readLine());
	// lol, ll, lo, ol, l, o 
	StringBuilder sb = new StringBuilder();
	for(int t = 1; t<=T; t++) {
		String str= br.readLine();
		
		if(str.contains("lol")) {
			sb.append("0");
		}
		else if(str.contains("ll") || str.contains("lo") || str.contains("ol")) {
			sb.append("1");
		}
		else if(str.contains("o")|| str.contains("l")) {
			boolean flag = true; 
			for(int i = 0; i<str.length()-2; i++) {
				if((str.charAt(i) == str.charAt(i+2)) && str.charAt(i) == 'l') 
					flag = false;
			}
			if(flag)
				sb.append("2");
			else 
				sb.append("1");
		}
		else sb.append("3");
		sb.append("\n");
	}
	
	System.out.print(sb.toString());
}
}

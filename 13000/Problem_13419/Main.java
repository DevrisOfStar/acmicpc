package Problem_13419;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		String text;
		for(int t = 1; t<=T; t++) {
			text = br.readLine();
			text += text;
			
			int length = text.length();
			String a = "", b = "";
			boolean flag = true;
			for(int i = 0; i<length/2;i++) {
				if(flag) flag = false;
				else if(a.charAt(0) == text.charAt(i*2) &&
					b.charAt(0) == text.charAt(i*2+1)) break;
				a += text.charAt(i*2);
				b += text.charAt(i*2+1);
			}
			sb.append(a).append("\n").append(b).append("\n");
		}
		System.out.println(sb.toString());
		
	}
}

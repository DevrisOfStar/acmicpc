package Problem_1212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static String[] number = {"000","001","010","011","100","101","110","111"};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		if(!str.equals("0")) {
			for(int i = 0; i< str.length(); i++) {
				sb.append(number[str.charAt(i) - '0']);
			}
			
			str = sb.toString();
			while(str.charAt(0) == '0') {
				str = str.substring(1);
			}	
		}
		System.out.println(str);
		
	}
}

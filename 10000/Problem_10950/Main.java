package Problem_10950;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String str;
		int a, b;
		for(int t = 1; t<=T;t++) {
			str = br.readLine();
			a = Integer.parseInt(str.split(" ")[0]); 
			b = Integer.parseInt(str.split(" ")[1]);
			System.out.println(a+b);
		}
		
	}
}

package Problem_1009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int a,b,c, answer;
		String str;
		for(int i = 0; i < T; i++) {
			str = br.readLine();
			a = Integer.parseInt(str.split(" ")[0]);
			b = Integer.parseInt(str.split(" ")[1]);
			
			answer = 1;
			c = a % 10;
			for(int j = 0; j < b; j++) {
				answer = (answer * c) % 10; 
			}
			if(answer == 0) answer = 10;
			System.out.println(answer);
		}
		
	}
}

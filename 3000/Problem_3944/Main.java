package Problem_3944;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String str;
		int a;
		int answer;
		for(int t = 0; t<T; t++) {
			str = br.readLine();
			a = Integer.parseInt(str.split(" ")[0])-1;
			str = str.split(" ")[1];
			answer = 0;
			for(int i = 0; i<str.length(); i++) {
				answer = answer + (str.charAt(i) -'0');
				answer %= a;
			}
			System.out.println(answer);
		}
	}
}

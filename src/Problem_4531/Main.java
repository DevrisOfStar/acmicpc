package Problem_4531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int findNumber(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			String str = br.readLine();
			int a, b;
			int answer = 0;

			a = findNumber(str.charAt(0));
			for (int i = 1; i < str.length(); i++) {
				b = findNumber(str.charAt(i));

				if (a < b) {
					answer -= a;
				} else {
					answer += a;
				}
				a = b;
			}

			answer += a;

			System.out.println(answer);

		}
	}
}

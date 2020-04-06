package Problem_1343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String A = "AAAA";
		String B = "BB";

		int cnt = 0;
		int num = 0;
		String str = br.readLine();

		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'X')
				cnt++;
			else {
				if (cnt >= 4) {
					num = cnt / 4;
					cnt %= 4;
					for (int j = 0; j < num; j++)
						answer.append(A);
				}
				if (cnt >= 2) {
					cnt -= 2;
					answer.append(B);
				}

				if (cnt > 0) {
					System.out.println(-1);
					return;
				}
				answer.append(".");
			}
		}

		if (cnt >= 4) {
			num = cnt / 4;
			cnt %= 4;
			for (int j = 0; j < num; j++)
				answer.append(A);
		}
		if (cnt >= 2) {
			cnt -= 2;
			answer.append(B);
		}

		if (cnt > 0) {
			System.out.println(-1);
			return;
		}

		System.out.println(answer.toString());
	}
}

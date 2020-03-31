package Problem_8958;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t<=T;t++) {
			int score = 0;
			int cnt = 0;
			for(char c : br.readLine().toCharArray()) {
				if(c == 'O') {
					cnt++;
					score += cnt;
				} else {
					cnt = 0;
				}
			}
			System.out.println(score);
		}
	}
}

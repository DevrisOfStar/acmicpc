package Problem_2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] cup = new int[N + 1];
		int[] dp = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			cup[i] = Integer.parseInt(br.readLine());
		}
		if (N == 1) {
			System.out.println(cup[N]);
			return;
		} else if (N == 2) {
			System.out.println((cup[N] + cup[N - 1]));
			return;
		}
		dp[1] = cup[1];
		dp[2] = cup[1]+cup[2];

		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i-3] + cup[i-1] + cup[i], Math.max(dp[i - 2] + cup[i], dp[i - 1]));
		}

		System.out.println(dp[N]);
	}
}

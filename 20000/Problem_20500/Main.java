package Problem_20500;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[][] dp = new long[N+1][3];
		dp[1][1] = 1;
		long mod = 1000000007;
		for(int i = 2; i<=N;i++) {
			dp[i][0] = (dp[i-1][1] + dp[i-1][2]) % mod;
			dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % mod;
			dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % mod;
		}
		System.out.println(dp[N][0]);
	}
}

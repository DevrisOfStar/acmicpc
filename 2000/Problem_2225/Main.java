package Problem_2225;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		long[][] dp = new long[N+1][K+1];
		
		for(int i = 0; i<=N; i++) dp[i][1] = 1;
		
		for(int k = 2; k<=K;k++) {
			for(int i = 0; i<=N;i++) {
				for(int j = 0; j<=i;j++) {
					dp[i][k] += dp[j][k-1];
					dp[i][k] %= 1000000000;
				}
			}
		}
		
		System.out.println(dp[N][K]);
		
	}
}

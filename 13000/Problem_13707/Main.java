package Problem_13707;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		long[] dp = new long[10010];
		dp[0] = 1;
		dp[1] = 1;
		K = N+K-1;		
		for(int i = 2; i <= K; i++) {
			dp[i] = 1;
			for(int j = i-1; j>0;j--) {
				dp[j] = (dp[j] + dp[j-1]) % 1000000000;
			}
		}
		
		System.out.println(dp[N]);
	}
}

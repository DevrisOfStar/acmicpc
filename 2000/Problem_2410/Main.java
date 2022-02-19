package Problem_2410;

import java.util.Scanner;

public class Main {
	static long[] dp = new long[1000001];
	static long MOD = 1000000000; 
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		dp[1] = 1; dp[2] = 2;
		for(int i = 3; i<=N; i++) {
			if(i%2 == 1) dp[i] = dp[i-1];
			else dp[i] = (dp[i-1] + dp[i/2]) % MOD;
		}
		System.out.println(dp[N]);
	}
}

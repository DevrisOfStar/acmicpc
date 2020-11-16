package Problem_13699;

import java.util.Scanner;

public class Main {
	static long[] dp;

	public static long fn(int N) {
		// t(n)=t(0)*t(n-1)+t(1)*t(n-2)+...+t(n-1)*t(0)
		for (int i = 1; i <= N; i++) {
			for(int j = 0; j < i; j++) {
				dp[i] += dp[j]*dp[i-j-1];
			}
		}	
		return dp[N];

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp = new long[N + 1];
		dp[0] = 1;
		System.out.println(fn(N));
	}
}

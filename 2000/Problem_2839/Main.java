package Problem_2839;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if(N == 3 || N ==5) System.out.println(1);
		else if(N==4) System.out.println(-1);
		else {
			int[] dp = new int[N+1];
			dp[1] = 2000; dp[2] = 2000; dp[4] = 2000;
			dp[3] = 1; dp[5] = 1;
			for(int i = 6; i<=N; i++) dp[i] = Math.min(dp[i-3] + 1, dp[i-5] + 1);
			System.out.println(dp[N] > 1999 ? -1 : dp[N]);
		}
	}
}

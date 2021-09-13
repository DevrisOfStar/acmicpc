package Problem_17271;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int mod_ = 1000000007;
		
		if(N == 1) 
			System.out.println(1);
		else {
			int[] dp = new int[N+1];
			dp[0] = 1;
			dp[1] = 1;
			
			for(int i = 2; i<=N;i++) {
				dp[i] = dp[i-1];
				if(i-M >= 0) dp[i] = (dp[i] + dp[i-M]) % mod_;
			}
			System.out.println(dp[N]);
		}
	}
}

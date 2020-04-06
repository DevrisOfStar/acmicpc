package Problem_17212;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] dp = new int[100001];

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 2;
		dp[4] = 2;
		dp[5] = 1;
		dp[6] = 2;
		dp[7] = 1;
		
		
		for(int i = 8; i<=N; i++) {
			
			if(i%7== 0) {
				dp[i] = i/7;
			}
			else {
				dp[i] = Math.min(dp[i-5],Math.min(dp[i-2], dp[i-1]))+1;
			}
		}
		
		System.out.println(dp[N]);
	}
}

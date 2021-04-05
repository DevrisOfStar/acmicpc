package Problem_1904;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[3];
		dp[0] = 1; dp[1] = 2;
		if(N == 1) System.out.println(dp[0]);
		else if(N == 2) System.out.println(dp[1]);
		else {
			// a_n = a_(n-1) + a_(n-2)*2
			for(int i = 3; i<=N;i++) {
				dp[2] = dp[1] + dp[0];
				dp[2]%= 15746;
				dp[0] = dp[1];
				dp[1] = dp[2];
			}
			System.out.println(dp[2]);
		}
	}
}

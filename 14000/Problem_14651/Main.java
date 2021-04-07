package Problem_14651;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double k = 1e9+9; 
		long[] dp = new long[33334];
		dp[1] = 0; dp[2] = 2; 
		for(int i = 3; i<=N;i++) {
			dp[i] = (long) ((dp[i-1]*3) % k);
		}
		System.out.println(dp[N]);
	}
}

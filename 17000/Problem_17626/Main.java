package Problem_17626;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int cnt;
	static int[] dp = new int[50001];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Arrays.fill(dp, 1000000);
		for(int i = 1; i*i<=50000;i++) {
			dp[i*i] = 1;
		}
		
		for(int i = 2; i<=N; i++) {
			for(int j = 1; j*j<=i;j++) {
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);	
			}
		}
		
		System.out.println(dp[N]);
	}
}

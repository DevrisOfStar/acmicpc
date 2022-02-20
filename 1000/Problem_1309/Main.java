package Problem_1309;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[3]; // xx, 0x, x0
		int[] dp = new int[3];
		int mod = 9901;
		dp[0] = 1; dp[1] = 1; dp[2] = 1;
		for(int i = 2; i<=N; i++) {
			arr[0] = dp[0]; arr[1] = dp[1]; arr[2] = dp[2];
			dp[0] = (arr[0] + arr[1] + arr[2]) % mod;
			dp[1] = (arr[0] + arr[2]) % mod;
			dp[2] = (arr[0] + arr[1]) % mod;
		}
		int answer = (dp[0] + dp[1] + dp[2]) % mod;
		System.out.println(answer);
	}
}

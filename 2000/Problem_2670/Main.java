package Problem_2670;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double[] arr = new double[N];
		double[] dp = new double[N];
		for(int i = 0; i<N; i++) arr[i] = sc.nextDouble();
		dp[0] = arr[0];
		double max = dp[0];
		for(int i = 1 ; i<N;i++) {
			dp[i] = Math.max(arr[i]*dp[i-1], arr[i]);
			max = Math.max(max, dp[i]);
		}
		System.out.printf("%.3f", max);
	}
}

package Problem_2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		for(int i = 1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp[1] = arr[1];
		
		
		if(N >= 2) {
			dp[2] = dp[1]+arr[2];
		}
		
		

		for(int j = 3; j<=N; j++) {
			 dp[j] = Math.max(dp[j-2] + arr[j], dp[j-3] + arr[j-1] + arr[j]);
		}
		
		System.out.println(dp[N]);
	}
}

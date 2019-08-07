package Problem_15988;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long[] dp = new long[10000001];
	static long p = 1000000009;
	public static long dp(int k) {
		if(dp[k] > 0) return dp[k];
		else {
			for(int i = 4; i<=k;i++) {
				dp[i] = dp[i-3]%p+dp[i-2]%p+dp[i-1]%p;
				dp[i] %= p;
			}
			return dp[k];
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		dp[0] = 0; dp[1] = 1; dp[2] = 2; dp[3] = 4;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <=T; t++) {
			int k = Integer.parseInt(br.readLine());	
			System.out.println(dp(k));
		}
	}
}

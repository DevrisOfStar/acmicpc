package Problem_2294;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static long[] coins;
	static long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int n = Integer.parseInt(str.split(" ")[0]);
		int m = Integer.parseInt(str.split(" ")[1]);
		coins = new long[n];
		
		dp = new long[m+1];
		Arrays.fill(dp, Integer.MAX_VALUE);

		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < n; i++) {
			if(coins[i] <= m)
			dp[(int) coins[i]] = 1;
		}
		
		
		for (int i = 0; i < n; i++) {
			for (int j = (int) coins[i]; j <= m; j++) {
				if(j-coins[i] >= 0) {
					dp[j] = Math.min(dp[(int) (j-coins[i])]+1, dp[j]);
				}
			}
			
		}
		if(dp[m]!=Integer.MAX_VALUE)
		System.out.println(dp[m]);
		else System.out.println("-1");
	}
}

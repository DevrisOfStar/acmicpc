package Problem_2293;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		
		dp[0] = 1;
		
		for (int i = 0; i < n; i++) {
			for (int j = (int) coins[i]; j <= m; j++) {
				if(j-coins[i] >= 0) {
					dp[j] += dp[(int) (j-coins[i])];
				}
			}
			
		}
		
		System.out.println(dp[m]);
	}
}

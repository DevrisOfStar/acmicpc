package Problem_14494;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buf = br.readLine();
		int N = Integer.parseInt(buf.split(" ")[0]);
		int M = Integer.parseInt(buf.split(" ")[1]);
		long[][] dp = new long[N+1][M+1];
		
		for(int i = 1; i<=N; i++) dp[i][1] = 1;
		for(int j = 1; j<=M; j++) dp[1][j] = 1;
		
		for(int i = 2; i<=N; i++) {
			for(int j =2; j<=M;j++) {
				dp[i][j] = (dp[i][j-1] + dp[i-1][j] + dp[i-1][j-1]);
				dp[i][j] %= 1000000007;
			}
		}
		
		System.out.println(dp[N][M]);
		
	}
}

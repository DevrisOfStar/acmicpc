package Problem_1359;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] dp = new int[9][9];
	
	static int N,M,K;
	static int tot, got;
	static int getAnswer(int n, int k) {
		if(k == 0) k = n;
		
		dp[1][1] = dp[1][0] = 1;
		if(dp[n][k] > 0) return dp[n][k];
		
		for(int i = 2; i<=n; i++) {
			dp[i-1][0] = 1;
			for(int j = 1; j<=i; j++) {
				dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
			}
		}
		
		return dp[n][k];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		N = Integer.parseInt(str.split(" ")[0]);
		M = Integer.parseInt(str.split(" ")[1]);
		K = Integer.parseInt(str.split(" ")[2]);
		
		double answer = 0;
		do {
			answer += (double)getAnswer(M,K)*(double)getAnswer(N-M, M-K) / (double)getAnswer(N,M);
		} while(++K <= M);
		
		System.out.println(answer);
	}
}

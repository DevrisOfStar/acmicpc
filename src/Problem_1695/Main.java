package Problem_1695;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");
		int[][] dp = new int[N + 1][N + 1];
		// int[][] dp = new int[2][N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (arr[i-1].equals(arr[N - j])) {
					dp[i][j] = dp[i-1][j-1] +1; 
					// dp[i%2][j] = dp[(i-1)%2][j-1]+1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
					// dp[i%2][j] = Math.max(dp[(i-1)%2][j], dp[i%2][j-1]);
				}
			}
		}
		
		System.out.println(N-dp[N][N]);
	}
}

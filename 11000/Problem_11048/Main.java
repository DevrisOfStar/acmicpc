package Problem_11048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(str.split(" ")[0]);
		int M = Integer.parseInt(str.split(" ")[1]);
		int[][] arr = new int[N][M];
		int[][] dp = new int[N][M];
		StringTokenizer st;
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = arr[0][0];
		for(int i = 1; i<N;i++) dp[i][0] = dp[i-1][0] + arr[i][0];
		for(int j = 1; j<M;j++) dp[0][j] = dp[0][j-1] + arr[0][j];
		for(int i = 1; i<N;i++) {
			for(int j = 1; j<M;j++) {
				dp[i][j] = Math.max(dp[i-1][j], 
						Math.max(dp[i][j-1], dp[i-1][j-1])) + arr[i][j];
			}
		}
		System.out.println(dp[N-1][M-1]);
	}
}

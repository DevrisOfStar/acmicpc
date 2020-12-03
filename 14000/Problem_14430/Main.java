package Problem_14430;

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
		boolean[][] arr = new boolean[N][M];
		int[][] dp = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				if(st.nextToken().equals("1")) arr[i][j] = true;
			}
		}
		int num = 0;
		for(int i = 0; i<N;i++) {
			if(arr[i][0]) dp[i][0] = ++num;
			else dp[i][0] = num;
		}
			
		
		num = 0;
		for(int j = 0; j<M;j++) {
			if(arr[0][j]) dp[0][j] = ++num;
			else dp[0][j] = num;
		}
		
		for(int i = 1; i<N;i++) {
			for(int j = 1; j<M;j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + (arr[i][j] ? 1 : 0);
			}
		}
		
		System.out.println(dp[N-1][M-1]);
		
	}
}

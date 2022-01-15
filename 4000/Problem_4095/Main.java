package Problem_4095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		boolean[][] map = new boolean[1001][1001];
		int[][] dp = new int[1001][1001];
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while(true) {
			str = br.readLine();
			int N = Integer.parseInt(str.split(" ")[0]);
			int M = Integer.parseInt(str.split(" ")[1]);
			if(N == 0 && M == 0) break;
			for(int i = 1; i<=N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 1; j<=M; j++) {
					map[i][j] = st.nextToken().equals("1") ? true : false;
				}
			}
			
			for(int i = 1; i<=N; i++) dp[i][1] = map[i][1] ? 1 : 0; 
			for(int j = 1; j<=M; j++) dp[1][j] = map[1][j] ? 1 : 0;
			for(int i = 2; i<=N; i++) {
				for(int j =2; j<=M; j++) {
					int min = Math.min(Math.min(dp[i-1][j], dp[i][j-1]),dp[i-1][j-1]);
					if(map[i][j]) dp[i][j] = min+1;
				}
			}
			
			int max = 0;
			for(int i = 1; i<=N; i++) 
				for(int j = 1; j<=M; j++) 
					if(max < dp[i][j]) max = dp[i][j]; 

			sb.append(max).append("\n");
			
			for(int i = 1; i<=N; i++) {
				Arrays.fill(map[i], false);
				Arrays.fill(dp[i], 0);
			}
		}
		System.out.print(sb.toString());
	}
}

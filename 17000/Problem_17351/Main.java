package Problem_17351;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static char[][] map;
	static int[][] dp;
	static int[] dx = {1, 0};
	static int[] dy = {0, 1};
	static char[] text = {'M','O','L','A'};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N+1][N+1];
		dp = new int[N+1][N+1];
		
		String bf;
		for(int i = 1; i<=N; i++) {
			bf = br.readLine();
			for(int j = 1; j<=N; j++) 
				map[i][j] = bf.charAt(j-1);
		}
		
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				dp[i][j] = Math.max(dp[i-1][j], Math.max(dp[i][j-1], solve(i,j,3)));
			}
		}
		
		System.out.println(dp[N][N]);
	}
	
	
	public static int solve(int x, int y, int cnt) {
		if(x <= 0 || y <= 0) return 0;
		if(map[x][y] == text[cnt]) {
			if(cnt == 0) return dp[x][y] + 1;
			return Math.max(solve(x-1,y, cnt-1), solve(x, y-1, cnt-1));	
		}
		return 0;
	}
}

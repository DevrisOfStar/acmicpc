package Problem_1915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String buf = br.readLine();
		
		int N = Integer.parseInt(buf.split( " ")[0]);
		int M = Integer.parseInt(buf.split( " ")[1]);
		
		boolean[][] map = new boolean[N][M];
		int[][] dp = new int[N][M];
		
		int a;
		for(int i = 0; i < N; i++) {
			buf = br.readLine();
			for(int j = 0; j <M; j++) {
				a = buf.charAt(j) - '0';
				if(a == 1) map[i][j] = true;
			}
		}
				
		int max = 0;
		for(int i = 0; i < N; i++) {
			if(map[i][0]) {
				dp[i][0] = 1;
				max = 1;
			}
		}
		for(int j = 0; j <M; j++) {
			
			if(map[0][j]) {
				dp[0][j] = 1;
				max = 1;
			}
		}
		for(int i = 1; i< N; i++) {
			for(int j = 1; j<M;j++) {
				if(map[i][j]) {
					if(map[i-1][j-1] && map[i-1][j] && map[i][j-1])
						dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i-1][j-1]), dp[i][j-1])+1;
					else dp[i][j] = 1;
					
					if(max < dp[i][j]) max = dp[i][j];
				}
			}
		}

		System.out.println(max * max);
	}
}

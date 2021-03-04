package Problem_9844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buf = br.readLine();
		int N = Integer.parseInt(buf.split(" ")[0]);
		int M = Integer.parseInt(buf.split(" ")[1]);
		int[][] arr = new int[N][M];
		int[][] dp = new int[N][M];
		for(int i = 0; i<N; i++) {
			buf = br.readLine();
			for(int j = 0; j<M; j++) {
				arr[i][j] = Integer.parseInt(buf.split(" ")[j]);
			}
		}
		for(int i = 0; i<M;i++) dp[N-1][i] = arr[N-1][i];
		int a = 0;
		int max = Integer.MIN_VALUE;
		for(int i = N-1; i>0;i--) {
			for(int j = 0; j<M;j++) {
				max = Integer.MIN_VALUE;
				for(int k = 0; k<=2;k++) {
					if(j+k-1 < 0 || j+k-1 >= M) continue;
					a = dp[i][j+k-1] + arr[i-1][j];
					if(max < a) max = a;
				}
				dp[i-1][j] = max;
			}
		}
		
		max = Integer.MIN_VALUE;
		for(int i = 0; i<M;i++) if(max < dp[0][i]) max = dp[0][i];
		System.out.println(max);
	}
}

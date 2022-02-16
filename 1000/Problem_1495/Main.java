package Problem_1495;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String t = br.readLine();
		int N = Integer.parseInt(t.split(" ")[0]);
		int S = Integer.parseInt(t.split(" ")[1]);
		int M = Integer.parseInt(t.split(" ")[2]);
		boolean[][] dp = new boolean[N+1][M+1];
		int[] data = new int[N];
		dp[0][S] = true;
		t = br.readLine();
		for(int i = 0; i<N; i++) {
			data[i] = Integer.parseInt(t.split(" ")[i]);
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<=M; j++) {
				if(dp[i][j]) {
					if(j + data[i] <= M) dp[i+1][j + data[i]] = true;
					if(j - data[i] >= 0) dp[i+1][j - data[i]] = true;
				}
			}
		}
		int answer = -1;
		for(int i = 0; i<=M; i++) {if(dp[N][i]) answer = i; }
		System.out.println(answer);
	}
}

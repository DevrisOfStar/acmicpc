package Problem_17208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][][] dp = new int[301][301][301];
	static int[] orderA, orderB;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String buffer = br.readLine();
		int N = Integer.parseInt(buffer.split(" ")[0]);
		int M = Integer.parseInt(buffer.split(" ")[1]);
		int K = Integer.parseInt(buffer.split(" ")[2]);
		orderA = new int[N+1];
		orderB = new int[N+1];
 
		for(int i = 1; i<=N;i++) {
			buffer = br.readLine();
			orderA[i] = Integer.parseInt(buffer.split(" ")[0]);
			orderB[i] = Integer.parseInt(buffer.split(" ")[1]);
		}
		
		System.out.println(solve(M,K,N));
	}
	
	public static int solve(int N, int M, int K) {
		if(N < 0 || M < 0) return -3000;
		if(K==1) {
			if(N >= orderA[K] && M >= orderB[K]) return 1;
			else return 0;
		}
		
		if(dp[N][M][K] > 0) return dp[N][M][K];
		dp[N][M][K] = Math.max(solve(N-orderA[K], M-orderB[K], K-1)+1, solve(N, M, K-1));
		return dp[N][M][K];
	}
}

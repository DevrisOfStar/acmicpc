package Problem_3372;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] arr = new long[N][N];
		BigInteger[][] dp = new BigInteger[N][N];
		String str;		
		for(int i = 0; i<N;i++) Arrays.fill(dp[i], BigInteger.ZERO);
		dp[0][0] = BigInteger.ONE;
		
		for(int i = 0; i<N; i++) {
			str = br.readLine();
			for(int j = 0; j<N; j++) {
				arr[i][j] = Long.parseLong(str.split(" ")[j]);
			}
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(arr[i][j] == 0) continue;
				if(i+arr[i][j] < N) 
					dp[(int) (i+arr[i][j])][j] = dp[(int) (i+arr[i][j])][j].add(dp[i][j]);
				if(j + arr[i][j] < N) 
					dp[i][(int) (j+arr[i][j])] = dp[i][(int) (j+arr[i][j])].add(dp[i][j]);
			}
		}
		
		System.out.println(dp[N-1][N-1].toString());
	}
}

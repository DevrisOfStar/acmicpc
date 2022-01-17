package Problem_9084;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		long[] dp = new long[10001];
		dp[0] = 1;
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(br.readLine());
			int[] c = new int[N];
			for(int i =0 ;i<N; i++) {
				c[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 0; i<N; i++) {
				for(int j = c[i]; j<=M;j++) {
					dp[j] += dp[j-c[i]];
				}
			}
			
			sb.append(dp[M]).append("\n");
			Arrays.fill(dp, 0l);
			dp[0] = 1;
		}
		System.out.print(sb.toString());
	}
}

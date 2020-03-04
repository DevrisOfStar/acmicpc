package Problem_11867;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int dp[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int N = Integer.parseInt(str.split(" ")[0]);
		int M = Integer.parseInt(str.split(" ")[1]);
		dp = new int[101][101];

		for (int i = 0; i <= 100; i++)
			Arrays.fill(dp[i], -1);
		
		System.out.println((proc(N, M) == 0 ? "A" : "B"));

	}
	
	public static int proc(int N, int M) {
		if(N <=0 || M<= 0) return -1;
		if(N == 1 && M == 1) return 1;
		if(dp[N][M] != -1) return dp[N][M];
		boolean flag = false;
		
		for(int i = 1; i<= N && !flag ; i++) {
			if(proc(i, N-i) == 1) flag = true;
			if(proc(N-i, i) == 1) flag = true;
			if(flag) break;
		}
		for(int i = 1; i<=M && !flag; i++) {
			if(proc(i, M-i) == 1) flag = true;
			if(proc(M-i, i) == 1) flag = true;
			if(flag) break;
		}
		
		return dp[N][M]=(flag?0:1);
	}
}

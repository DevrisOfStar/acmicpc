package Problem_1823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] arr;
	static long[][] dp;
	public static long getAnswer(int left, int right, int number) {
		if(left > right) return 0;
		if(dp[left][right] > 0) return dp[left][right];
		return dp[left][right] = Math.max(
				getAnswer(left+1, right, number+1) + arr[left] * number, 
				getAnswer(left, right-1, number+1) + number * arr[right]);				
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		for(int i = 1; i<=N;i++) arr[i] = Integer.parseInt(br.readLine());
		dp = new long[N+1][N+1];
		System.out.println(getAnswer(1,N,1));
	}
}

package Problem_1890;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[] dx = {0,1};
	static int[] dy = {1,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		long[][] dp = new long[N][N];
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		dp[0][0] = 1;
		
		for(int i = 0; i<N;i++) {
			for(int j = 0; j<N; j++) {
				int num = arr[i][j];
				if(i == N-1 && j == N-1) continue;
				if(i+num <N) {
					dp[i+num][j] += dp[i][j]; 
				}
				if(j+num <N) {
					dp[i][j+num] += dp[i][j];
				}
			}
		}
		System.out.println(dp[N-1][N-1]);
	}
}

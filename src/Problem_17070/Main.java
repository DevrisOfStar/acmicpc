package Problem_17070;

// 16637
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/* 메모리 및 실행시간 줄이는 방법 찾아보기 */

public class Main {// 0 : 가로, 1 : 대각선, 2 : 세로
	static int[][] arr;
	static int N;
	static int[][][] dp;

	public static void dp() {
		for (int i = 2; i <= N; i++) {
			if (arr[1][i] == 1) {
				break;
			}
			dp[1][i][0] = 1;
		}
		for (int i = 2; i <= N; i++) {
			for (int j = 2; j <= N; j++) {
			
				if (arr[i][j] == 1)
					continue;
		
				dp[i][j][0] = dp[i][j-1][0]+dp[i][j-1][1];
				dp[i][j][1] = dp[i-1][j-1][0] + dp[i-1][j-1][1]+dp[i-1][j-1][2];
				dp[i][j][2] = dp[i-1][j][1] + dp[i-1][j][2];
				
				if(arr[i-1][j] == 1 || arr[i][j-1] == 1) dp[i][j][1] = 0;
			}
		}

		int answer = dp[N][N][0] + dp[N][N][1] + dp[N][N][2];
		System.out.println(answer);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][N + 1];
		dp = new int[N + 1][N + 1][3];
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			for (int j = 1; j <= N; j++) {
				arr[i][j] = s.charAt(2 * (j - 1)) - '0';
			}
		}

		dp();

	}
}

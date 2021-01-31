package Problem_9658;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 창영 win : true, 상근 win : false
		int N = sc.nextInt();
		
		boolean[] dp = new boolean[1001];
		
		dp[1] = true;
		dp[3] = true;
		dp[4] = true;
		
		for(int i = 2; i<=N;i++) {
			boolean flag = false;
			if(i-1 >= 1) flag |= dp[i-1];
			if(i-3 >= 1) flag |= dp[i-3];
			if(i-4 >= 1) flag |= dp[i-4];
			dp[i] = !flag;
		}
		
		System.out.println(dp[N] ? "CY" : "SK");
	}
}

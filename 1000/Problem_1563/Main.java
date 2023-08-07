package Problem_1563;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[][][] dp = new long[N+1][2][3]; // 2 - 지각 0, 1, 3: 결석 - 연속 0, 1, 2
        int NUM = 1000000;
        dp[1][0][0] = 1;
        dp[1][1][0] = 1;
        dp[1][0][1] = 1;

        for(int i = 2; i<=N;i++) {
            dp[i][0][0] = (dp[i-1][0][0] + dp[i-1][0][1] + dp[i-1][0][2]) % NUM;
            dp[i][0][1] = (dp[i-1][0][0]) % NUM;
            dp[i][0][2] = (dp[i-1][0][1]) % NUM;
            
            dp[i][1][0] = (dp[i-1][0][0] + dp[i-1][0][1] + dp[i-1][0][2]+ dp[i-1][1][0] + dp[i-1][1][1] + dp[i-1][1][2]) % NUM;
            dp[i][1][1] = (dp[i-1][1][0]) % NUM;
            dp[i][1][2] = (dp[i-1][1][1]) % NUM;
        }

        long answer = dp[N][0][0] + dp[N][0][1] + dp[N][0][2] + dp[N][1][0] + dp[N][1][1] + dp[N][1][2];
        answer %= NUM;

        System.out.println(answer);
        sc.close();
    }
}

package Problem_2688;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        long[] answer = new long[65];
        long[][] dp = new long[65][10];
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < 10;i++) { dp[1][i] = 1; }
        answer[1] = 10;

        for(int i = 2; i<=64;i++) {
            long sum = 0;
            for(int j = 0; j<10;j++) {
                dp[i][j] = dp[i-1][j] + sum;
                sum += dp[i-1][j];
            }
            for(int j = 0; j<10;j++) 
                answer[i] += dp[i][j];
        }

        for(int t = 0; t<T;t++) {
            int n = sc.nextInt();
            sb.append(answer[n]).append("\n");
        }
        
        System.out.print(sb.toString());
        sc.close();
    }
}

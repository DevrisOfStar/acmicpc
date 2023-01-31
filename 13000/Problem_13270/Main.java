package Problem_13270;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[][] dp = new long[10001][2];
        for(int i = 1; i<=10000;i++) dp[i][0] = (long)(1e9);
        int a = 1, b = 2;
        while(b <= N) {
            for(int i = b; i<=N; i++) {
                dp[i][0] = Math.min(dp[i][0], dp[i-b][0] + a);
                dp[i][1] = Math.max(dp[i][1], dp[i-b][1] + a);
            }
            b = a+b;
            a = b-a;
        }
        
        System.out.println(dp[N][0] + " " + dp[N][1]);
        sc.close();
    }
}

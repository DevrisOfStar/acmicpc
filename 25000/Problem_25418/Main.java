package Problem_25418;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int K = sc.nextInt();
        int[] dp  = new int[K+1];
        Arrays.fill(dp, Integer.MAX_VALUE-1000000);

        dp[A] = 0;
        for(int i = A+1; i<=K;i++) {
            if(i%2 == 0) dp[i] = Math.min(dp[i/2], dp[i]) + 1;
            dp[i] = Math.min(dp[i-1]+1, dp[i]);
        }
        System.out.println(dp[K]);
        sc.close();
    }
}

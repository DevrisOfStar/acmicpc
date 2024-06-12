package Problem_2302;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] cnt = new int[N+1]; 
        long[] dp = new long[N+1];

        Arrays.fill(cnt, 1);

        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i<=N;i++) {
            dp[i] = dp[i-1]+ dp[i-2];
        }
        long answer = 1;
        int tmp = 0;

        for(int i = 0; i<M; i++) {
            int idx = sc.nextInt();
            answer *= dp[idx-1-tmp];
            tmp = idx;
        }
        answer *= dp[N-tmp];

        System.out.println(answer);

        sc.close();
    }
}

package Problem_2775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp = new int[20][20];

        for(int t = 0; t<T; t++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(solve(k,n));
        }
    }

    public static int solve(int k, int n) {
        if(k == 0) return n;
        if(n == 1) return 1;
        if(dp[k][n] > 0) return dp[k][n];
        return dp[k][n] = solve(k-1,n) + solve(k,n-1);
    }
}

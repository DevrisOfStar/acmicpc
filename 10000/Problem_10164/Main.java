package Problem_10164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String buf = br.readLine();
        int N = Integer.parseInt(buf.split(" ")[0]);
        int M = Integer.parseInt(buf.split(" ")[1]);
        int K = Integer.parseInt(buf.split(" ")[2]);
        int x = 0, y = 0;
        if(K!=0) {
            x = (K-1) / M;
            y = (K-1) % M;
        }
        
        int[][] dp = new int[N+1][M+1];
        for(int i = 0;i <= N;i++) dp[i][0] = 1;
        for(int i = 0;i <= M;i++) dp[0][i] = 1;
        for(int i = 1;i<=N;i++) {
            for(int j = 1; j<=M;j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        System.out.println(dp[x][y] * dp[N-x-1][M-y-1]);
    }
}

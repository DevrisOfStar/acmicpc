package Problem_12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String buf = br.readLine();
        
        N = Integer.parseInt(buf.split(" ")[0]);
        K = Integer.parseInt(buf.split(" ")[1]);

        int[][] data = new int[N+1][2];
        int[][] dp = new int[N+1][K+1];

        for(int i = 1; i<=N;i++) {
            buf = br.readLine();
            data[i][0] = Integer.parseInt(buf.split(" ")[0]); // W
            data[i][1] = Integer.parseInt(buf.split(" ")[1]); // V
        }

        int max = Integer.MIN_VALUE;

        for(int i = 1; i<=N; i++) {
            for(int j = 0; j<=K; j++) {
                if(data[i][0] <=j)
                    dp[i][j] = Math.max(dp[i-1][j], data[i][1]+dp[i-1][j-data[i][0]]);
                else
                    dp[i][j] = dp[i-1][j];
                max = Math.max(dp[i][j], max);
            }
        }
        
        System.out.println(max);
    }
}

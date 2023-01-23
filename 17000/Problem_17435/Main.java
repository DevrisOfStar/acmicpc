package Problem_17435;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int M, N;
    static final int log = 19;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        
        dp = new int[log+1][M+1];
        String buf = br.readLine();
        StringTokenizer st = new StringTokenizer(buf);
        for(int i = 1; i<=M; i++) dp[0][i] = Integer.parseInt(st.nextToken());
        
        for(int i = 1; i<=log; i++) {
            for(int j = 1; j<=M; j++) {
                dp[i][j] = dp[i-1][dp[i-1][j]];
            }
        }

        N = Integer.parseInt(br.readLine());
        
        for(int i = 1; i<=N; i++) {
            buf = br.readLine();
            sb.append(getAnswer(Integer.parseInt(buf.split(" ")[0]),
                Integer.parseInt(buf.split(" ")[1]))).append("\n");
            
        } 
        System.out.print(sb.toString());
    }

    static int getAnswer(int n, int x) {
        int cur = x;
        for(int i = log; i>=0; i--) {
            if((n & (1<<i)) == (1<<i)) {
                cur = dp[i][cur];
            }
        }
        return cur;
    }
}

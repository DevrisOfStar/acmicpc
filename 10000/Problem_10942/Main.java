package Problem_10942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[][] dp;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1][N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i<=N; i++) { arr[i] = Integer.parseInt(st.nextToken()); }
        for(int i = 0 ; i<=N; i++) Arrays.fill(dp[i], -1);

        int M = Integer.parseInt(br.readLine());
        String tmp;
        StringBuilder sb = new StringBuilder();
        while(M-- > 0) {
            tmp = br.readLine();
            sb.append(answer(Integer.parseInt(tmp.split(" ")[0]),Integer.parseInt(tmp.split(" ")[1]))).append("\n");
        }

        System.out.print(sb.toString());
    }

    public static int answer(int S, int E) {
        if(dp[S][E] > 0) return dp[S][E];
        if(E-S == 1) return dp[S][E] = arr[S] == arr[E] ? 1 : 0;    
        if(S == E) return dp[S][E] = 1;
        if(arr[S] != arr[E]) return dp[S][E] = 0;

        dp[S][E] = answer(S+1,E-1);
        return dp[S][E];
    }
}

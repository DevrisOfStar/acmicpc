package Problem_5557;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        long[][] answer = new long[2][21];
        answer[0][arr[0]]= 1;
        
        for(int i = 1; i<N-1;i++) {
            for(int j = 0; j<=20;j++) {
                if(j-arr[i] >= 0) {
                    answer[1][j-arr[i]] += answer[0][j];
                }
                if(j+arr[i] <= 20) {
                    answer[1][j+arr[i]] += answer[0][j];
                }
            }
            for(int j = 0; j<=20; j++) {
                answer[0][j] = answer[1][j];
                answer[1][j] = 0;
            }
        }
       
       
        
        System.out.println(answer[0][arr[arr.length-1]]);
        
    }
}

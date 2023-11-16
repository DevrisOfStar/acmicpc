package Problem_4097;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, Max;
    static int[] arr = new int[250001];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            N = Integer.parseInt(br.readLine());
            Max = Integer.MIN_VALUE;

            if(N == 0) break;
            for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
            
            for(int i = 1; i<N; i++) {
                arr[i] = Math.max(arr[i], arr[i-1]+ arr[i]);
                Max = Math.max(arr[i], Max);
            }
            sb.append(Max).append("\n");

            Arrays.fill(arr, 0);
        }

        System.out.print(sb.toString());
    }
}

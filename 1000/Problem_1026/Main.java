package Problem_1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr_a = new int[N];
        int[] arr_b = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) arr_a[i] = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) arr_b[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr_a);
        Arrays.sort(arr_b);

        long answer = 0;
        for(int i = 0; i<N;i++) answer += (arr_a[i] * arr_b[N-1-i]);        

        System.out.println(answer);
    }
}

package Problem_1350;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long answer = 0;
        long cluster = 0;
        long[] fileSizes =  new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N;i++) {
            fileSizes[i] = Long.parseLong(st.nextToken());
        }

        cluster = Long.parseLong(br.readLine());

        for(int i = 0; i < N ; i++) {
             answer += (cluster * Math.ceil((double)fileSizes[i] / (double) cluster));
        }

        System.out.println(answer);
    }
}

package Problem_13900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        long sumArr = 0;
        long answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N;i++) {
            arr[i] = Long.parseLong(st.nextToken());
            sumArr += arr[i];
        }

        for(int i = 0; i<N; i++) {
            sumArr -= arr[i];
            answer += (arr[i] * sumArr);
        }

        System.out.println(answer);
    }
}
package Problem_1037;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;

        for(int i = 0; i<arr.length;i++) {
            arr[i] = Long.parseLong(st.nextToken());
            if(max < arr[i]) max = arr[i];
            if(min > arr[i]) min = arr[i];
        }

        System.out.println(max * min);
    }
}

package Problem_9507;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] arr = new long[100];

    public static void main(String[] args) throws NumberFormatException, IOException {
        arr[0] = 1; arr[1] = 1; arr[2] = 2; arr[3] = 4;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(getAnswer(n)).append("\n");
        }
        System.out.print(sb.toString());
    }

    public static long getAnswer(int n) {
        if(arr[n] > 0) return arr[n];
        if(n>3) return arr[n] = getAnswer(n-1) + getAnswer(n-2) + getAnswer(n-3) + getAnswer(n-4);
        return arr[n];
    }
}

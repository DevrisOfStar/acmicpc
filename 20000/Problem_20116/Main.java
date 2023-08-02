package Problem_20116;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String buf = br.readLine();
        int N = Integer.parseInt(buf.split(" ")[0]);
        int K = Integer.parseInt(buf.split(" ")[1]);
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        double amount = 0, avg = 0;
        double min = 0, max = 0;
        boolean flag = true;

        for(int i = 0; i<arr.length; i++) arr[i] = Long.parseLong(st.nextToken());
        
        for(int i = arr.length-1; i > 0;i--) {
            amount += (double)arr[i];
            min = (double)arr[i-1] - (double)K;
            max = (double)arr[i-1] + (double)K;
            avg = amount / (double)(arr.length-i);
            if(min >= avg || max <= avg) {
                flag = false;
                break;
            }
        }
        System.out.println(flag ? "stable" : "unstable");
    }
}

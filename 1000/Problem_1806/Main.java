package Problem_1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String buf = br.readLine();
        long N = Long.parseLong(buf.split(" ")[0]);
        long S = Long.parseLong(buf.split(" ")[1]);
        long[] arr = new long[(int)N];
        buf = br.readLine();
        StringTokenizer st = new StringTokenizer(buf);
        for(int i = 0; i<N;i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        int pl=0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;
        for(int pr = 0; pr <N; pr++) {
            sum+=arr[pr];
        
            while(sum >= S) {        
                if(answer > pr-pl+1) {
                    answer = pr-pl+1;
                }
                sum-=arr[pl];
                pl++;
            }
        }

        if(answer != Integer.MAX_VALUE) System.out.println(answer);
        else System.out.println(0);
    }
}

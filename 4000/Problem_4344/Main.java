package Problem_4344;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int T = Integer.parseInt(str);
        StringBuilder sb = new StringBuilder();

        for(int t = 0; t<T; t++) {
            str = br.readLine();
            int N = Integer.parseInt(str.split(" ")[0]);
            int[] arr = new int[N];

            int sum = 0;
            for(int i = 0; i<N; i++)  {
                arr[i] = Integer.parseInt(str.split(" ")[i+1]);
                sum += arr[i];
            }
            double avg = (double)sum / (double)N;
            int cnt = 0;
            for(int i = 0; i<N; i++) {
                if(avg < arr[i]) cnt++;
            }
            double avg2 = (double)cnt / (double)N * 100.0;
            sb.append(String.format("%.3f",avg2)).append("%").append("\n");    
        }
        System.out.print(sb.toString());
    }
}

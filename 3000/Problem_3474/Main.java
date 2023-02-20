package Problem_3474;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t<=T; t++) {
            int N = Integer.parseInt(br.readLine());
            int two = 0, five = 0;
            for(int i = 2; i<=N; i*=2) two += N/i;
            for(int i = 5; i<=N; i*=5) five += N/i;
            sb.append(Math.min(two, five)).append("\n");
        }
        
        System.out.print(sb.toString());
    }
}

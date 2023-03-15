package Problem_5347;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String buf;
        long a, b, answer;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<N;i++){
            buf = br.readLine();
            a = Long.parseLong(buf.split(" ")[0]);
            b = Long.parseLong(buf.split(" ")[1]);

            if(a < b) {
                long temp = b;
                b = a;
                a = temp;
            }

            answer = a*b / gcd(a,b);
            sb.append(answer).append("\n");
        } 

        System.out.print(sb.toString());
    }

    public static long gcd(long a, long b) {
        long r = 1;
        while(b != 0) {
            r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}

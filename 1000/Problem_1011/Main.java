package Problem_1011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bf;
        int T = Integer.parseInt(br.readLine());
        long a, b, m;
        for(int t = 1; t<=T; t++) {
            bf = br.readLine();
            a = Long.parseLong(bf.split(" ")[0]);
            b = Long.parseLong(bf.split(" ")[1]);
            m = b-a;
            
            long n = 0l;
            
            for(;true;) { if(m <= n*(n+1)) break; n++;}
            
            if(m <= n*n) System.out.println(2*n-1);
            else System.out.println(2*n);
        }
    }
}

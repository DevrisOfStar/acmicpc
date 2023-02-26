package Problem_1075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long F = Long.parseLong(br.readLine());
        N-=N%100;
        
        for(int i = 0; i<100;i++) {
            if((N+i)%F == 0) {
                System.out.printf("%02d", i);
                return;
            }
        }
    }
}

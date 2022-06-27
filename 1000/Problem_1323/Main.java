package Problem_1323;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long N = sc.nextLong();
        long K = sc.nextLong();
        boolean[] isvisited = new boolean[(int)K];
        
        long cnt = 1;
        long jari = 0;
        long temp = N;

        for(int i = 0; i<20; i++) {
            if(temp == 0) break;    
            temp/=10;
            jari++;
        }
        jari = (long) Math.pow(10, jari);
        temp = N;
        while(true) {
            temp = temp%K;
            if(temp == 0) break;
            if(isvisited[(int)temp]) {
                cnt = -1;
                break;
            }
            isvisited[(int)temp] = true;
            temp = (temp*jari)%K + N;
            cnt++;
        }

        System.out.println(cnt);
        sc.close();
    }
}

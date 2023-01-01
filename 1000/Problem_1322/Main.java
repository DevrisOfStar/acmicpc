package Problem_1322;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long K = sc.nextLong();

        String N_str = Long.toBinaryString(N);
        String K_str = Long.toBinaryString(K);
        StringBuilder sb = new StringBuilder();
        int idx_K = K_str.length()-1;

        for(int i = N_str.length()-1; i>=0; i--) {
            char c = N_str.charAt(i);
            if(c == '1') {
                sb.insert(0,0);
            } else {
                if(idx_K < 0) continue;
                sb.insert(0, K_str.charAt(idx_K--));
            }
        }

        while(idx_K>=0) {
            sb.insert(0, K_str.charAt(idx_K--));
        }

        System.out.println(Long.parseLong(sb.toString(),2));
        
        sc.close();
    }
}

package Problem_2441;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int N = sc.nextInt();
        int bln = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<N; i++) {
            for(int j = bln; j > 0; j--)  sb.append(" ");
            for(int j = N-bln; j>0; j--)  sb.append("*"); 
            bln++;
            sb.append("\n");
        }

        System.out.print(sb.toString());
        sc.close();
    }
}

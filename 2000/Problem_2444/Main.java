package Problem_2444;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int N = sc.nextInt();
        int bln = 0;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<N; i++) {
            if(bln != 0) {
                for(int j = bln; j < N; j++)  sb.append(" ");
                for(int j = 2*bln-1; j>0; j--)  sb.append("*");     
                sb.append("\n");
            }
            bln++;
        }
        
        for(int i = 0; i<N; i++) {
            for(int j = bln; j < N; j++)  sb.append(" ");
            for(int j = 2*bln-1; j>0; j--)  sb.append("*"); 
            bln--;
            sb.append("\n");
        }

        System.out.print(sb.toString());
        sc.close();
    }
}
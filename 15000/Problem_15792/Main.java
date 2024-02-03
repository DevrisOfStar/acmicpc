package Problem_15792;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        sb.append(A/B).append(".");
        A %= B;
        A *= 10;
        for(int i = 0;i<1999;i++) {
            if(A == 0) break;
            sb.append(A/B);
            A%=B;
            A*=10;
        }
        
        System.out.println(sb.toString());

        sc.close();
    }
}
